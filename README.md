# RAHMS-Android-App

This repo contains Java project files for the Android App to display the Real-time Autonomous Horticulture Monitoring System (RAHMS) sensor values and photo.

![RAHMS in greenhouse](https://github.com/monrab/assets/blob/main/RAHMS%20Client.jpeg?raw=true)

## Android Versions
```java
minSdkVersion 16
targetSdkVersion 30
```
### Linking Firebase
[Firebase documentation](https://firebase.google.com/docs/android/setup#:~:text=Open%20the%20Firebase%20Assistant%3A%20Tools,your%20Android%20project%20with%20Firebase.)

### Android App Activity screen
Opening Activity allows user sign-in and registration with Firebase. 
The second Activity screen of the app contains ScrollView and an ImageView as below.

![android app](https://github.com/monrab/assets/blob/main/Android%20Mobile%20application%20screenshot%20(2)%20-%20Copy.png?raw=true)

### RAHMS.java
The declared variables for this object need to be the same names as the keys in the Firebase nodes, the same order and the same data type.
```java
    public RAHMS(Double BME280_Hum, Double BME280_Pres, Double BME280_Temp, Double CCS811_CO2, Double CCS811_tVOC, Double soil_Temp, Double soil_Moisture, Double LDR) {
        this.BME280_Hum = BME280_Hum;
        this.BME280_Pres = BME280_Pres;
        this.BME280_Temp = BME280_Temp;
        this.CCS811_CO2 = CCS811_CO2;
        this.CCS811_tVOC = CCS811_tVOC;
        this.Soil_Temp = soil_Temp;
        this.Soil_Moisture = soil_Moisture;
        this.LDR = LDR;
    }
```
The FirebaseDatabaseHelper.java creates the RAMHS object and assigns the values of the node's keys to the variables. 
```java
 public void readSensors(final DataStatus dataStatus) {
        mReferenceRahms.orderByChild(dateString).limitToLast(5).addValueEventListener(new ValueEventListener() { // reading last 5 entries
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                sensors.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : snapshot.getChildren()) {
                    keys.add(keyNode.getKey());
                    RAHMS rahms = keyNode.getValue(RAHMS.class);
                    sensors.add(rahms);
                }
                dataStatus.DataIsLoaded(sensors, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
```



