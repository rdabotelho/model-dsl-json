package com.m2r.mdsljson;

import com.m2r.easyparser.ParserException;
import com.m2r.mdsl.ModelDsl;
import com.m2r.mdsljson.model.Domain;
import com.m2r.mdsljson.model.DomainAttribute;
import com.m2r.mdsljson.model.DomainList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("File required!");
            return;
        }
        try {
            parse(args[0]);
        }
        catch (ParserException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void parse(String fileName) throws ParserException {
        File file = new File(fileName);
        System.out.println(String.format("Parsing file %s...", file.getName()));
        DomainList metadata = convertToObjectJson(ModelDsl.parse(file));
        saveJson(file, metadata.toString());
    }

    private static void saveJson(File file, String content) {
        Path filePath = Path.of("metadata.json");
        try {
            Files.write(filePath, content.getBytes());
            System.out.println(String.format("File %s parse successful", file.getName()));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static DomainList convertToObjectJson(com.m2r.mdsl.model.DomainList domainListFrom) {
        List<Domain> domains = domainListFrom.getDomains().stream()
                .map(d -> {
                    Domain domain = new Domain(d.getType().getValue(), d.getName().getValue(), d.isEntity(), d.isEnum());
                    List<DomainAttribute> attributes = d.getAttributes().stream()
                            .map(a -> {
                                DomainAttribute domainAttribute = new DomainAttribute(
                                        a.getType().getValue(),
                                        a.getName().getValue(),
                                        a.isBasic(),
                                        a.isEntity(),
                                        a.isEnum(),
                                        a.isList(),
                                        a.isOneToOne(),
                                        a.isOneToMany(),
                                        a.isManyToOne(),
                                        a.isManyToMany(),
                                        domain.getName()
                                );
                                domainAttribute.getParams().putAll(a.getParams().entrySet()
                                        .stream()
                                        .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().toString())));
                                return domainAttribute;
                            })
                            .collect(Collectors.toList());
                    domain.setAttributes(attributes);
                    domain.getParams().putAll(d.getParams().entrySet()
                            .stream()
                            .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().toString()))
                    );
                    return domain;
                })
                .collect(Collectors.toList());
        return new DomainList(domains);
    }

}
