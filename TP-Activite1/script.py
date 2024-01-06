# Python script to read the first 100 lines from a file and write them to a new file

# The name of the file to be read
input_file_name = '20231214-LEXICALNET-JEUXDEMOTS-ENTRIES-MWE.txt'

# The name of the new file to write the lines into
output_file_name = 'first_100_lines.txt'

# Open the input file and read the first 100 lines
with open(input_file_name, 'r', encoding='iso-8859-1') as file:
    first_100_lines = [next(file) for _ in range(100)]


# Write these lines into the new file
with open(output_file_name, 'w',  encoding='iso-8859-1') as file:
    file.writelines(first_100_lines)

# Inform the user that the task is completed
print("Les 100 premières lignes ont été écrites dans le fichier '{}'.".format(output_file_name))
