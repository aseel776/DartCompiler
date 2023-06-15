class audi extends cars { 
String name ; 
int carId ; 
audi ({required this.name, required int carId}){ 
this.carId = carId;
}
audi.name(String name){ 
this.name = name;
}
audi.id(this.id);
int addNewCar (String name) { 
var newCarId = carId+1
var newCar = new audi(name: name, carId: newCarId)
}
}