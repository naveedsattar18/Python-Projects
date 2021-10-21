# Things to Note
# Order of storing: Name, price, category, condition, Description
''' If input is stored in lists, use list indexing to search and pick
out results. '''

def search_by_name():
    # code to search through database
    name = str(input('Enter Item Name: '))
    file = open( '''NameofDatafile''', 'r')
    
    for line in file: # the next few lines go through each line in CSV file
        line = line[:-1]
        fields = line.split(',')
        if name in fields[0]:
            print(fields[0]) # prints name of Item
            ''' display image '''
            print(fields[1]) # Prints price
            print(fields[2]) # Prints Category
            print(fields[3]) # Prints Condition 
            print(fields[4]) # Prints Description
            print() # Line Break
        else:
            continue
        
def search_by_price():
    # code to search through database
    # Price Ranges: Upto $10, 25, 50, 100
    
    #Insert Code to Select Price Range either from drop-down menu or by
    # entering price range
    
    price = int(input('Enter Maximum Price: '))
    
    file = open('''NameofDatafile''', 'r')
    
    for line in file: # the next few lines go through each line in CSV file
        line = line[:-1]
        fields = line.split(',')
        if fields[1] <= price:
            print(fields[0]) # prints name of Item
            ''' display image '''
            print(fields[1]) # Prints price
            print(fields[2]) # Prints Category
            print(fields[3]) # Prints Condition 
            print(fields[4]) # Prints Description
            print() # Line Break
        else:
            continue

def search_by_category():
    # code to search through database
    # Categories: Electronics, Food Items, Decor, Computer and Accessories
    # Stationaries
    

    file = open('''NameofDatafile''', 'r')
    # Code for Choice from Categories
    
    for line in file: # the next few lines go through each line in CSV file
        line = line[:-1]
        fields = line.split(',')
        if fields[2] == Categories:
            print(fields[0]) # prints name of Item
            ''' display image '''
            print(fields[1]) # Prints price
            print(fields[2]) # Prints Category
            print(fields[3]) # Prints Condition 
            print(fields[4]) # Prints Description
            print() # Line Break
        else:
            continue
    
def search_by_condition():
    # code to search through database
    # Conditions: New, Used, Not Working
    
    
    file = open('''NameofDatafile''', 'r')
    #Code for Choice from Condition
    
    for line in file: # the next few lines go through each line in CSV file
        line = line[:-1]
        fields = line.split(',')
        if fields[3] == Condition:
            print(fields[0]) # prints name of Item
            ''' display image '''
            print(fields[1]) # Prints price
            print(fields[2]) # Prints Category
            print(fields[3]) # Prints Condition 
            print(fields[4]) # Prints Description
            print() # Line Break
        else:
            continue

def main():
    ''' the main user searching loop ''' 
        
    if choice = "Name":
        search_by_name()
        
    if choice = "Price":
        search_by_price()
        
    if choice = "Category":
        search_by_category()
        
    if choice = "Condition":
        search_by_condition()
        
if __name__== '__main__':
    
    # I wasn't sure what to put here lol
        
    
    
