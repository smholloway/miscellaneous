names = [
  'david',
  'jonathan',
  'kelly',
  'mason',
  'xander',
]

phrases = [
  'louis armstrong',
  'first you make a roux and then',
  'carnival parade barricade',
  'oysters rockefeller',
  'new orleans jazz and heritage festival',
]

for name in names:
  print("\nchecking name {}\n==========".format(name))
  for phrase in phrases:
    found = True
    for letter in name:
      name_count = name.count(letter)
      phrase_count = phrase.count(letter)
      if name_count > phrase_count:
        found = False
        break
    if not found:
      continue
    else:
      print(phrase)
  if found:
    continue
