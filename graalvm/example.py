import subprocess
import json

subprocess.run('./output/model-dsl-json-macos test.model', shell=True)

with open('metadata.json', 'r') as json_file:
    data = json.load(json_file)

for domain in data['domains']:
    print(domain['name'])