def calculate_total_cost(meal_cost, tip_percent, tax_percent):
    tip = meal_cost * tip_percent / 100
    tax = meal_cost * tax_percent / 100
    total_cost = meal_cost + tip + tax
    return round(total_cost)

# Dynamic input
meal_cost = float(input("Enter meal cost: "))
tip_percent = int(input("Enter tip percent: "))
tax_percent = int(input("Enter tax percent: "))

print("Total meal cost:", calculate_total_cost(meal_cost, tip_percent, tax_percent))