package com.sentry.Sentry.entity;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name = "sensor_data")
public class SensorData {
    //define fields
    @Id

    @Column(name = "ID")
    private int id;

    @Column(name = "SENSOR_STATUS")
    private double sensor_status;

    @Column(name = "TIMESTAMP")
    private Timestamp timestamp;

    @Column(name = "FK_SENSOR_ID")
    private int fk_sensor_id;
    
    @Column(name = "SENSOR_VALUE")
    private float sensor_value;
    



    //constructors
    public SensorData(){

    }

    public SensorData(int id, double sensor_status, Timestamp timestamp, int  fk_sensor_id, float sensor_value) {
        this.id = id;
        this.sensor_status =  sensor_status;
        this.timestamp =  timestamp;
        this.fk_sensor_id = fk_sensor_id;
        this.sensor_value = sensor_value;
        

    }
    
    



    //getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public double getSensorStatus() {
        return sensor_status;
    }

    public void setSensorStatus(double sensor_status) {
        this.sensor_status = sensor_status;
    }
    public Timestamp getTime() {
        return timestamp;
    }

    public void setTime(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getFKSensorID() {
        return fk_sensor_id;
    }

    public void setFKSensorID(int fk_sensor_id) {
        this.fk_sensor_id = fk_sensor_id;
    }
    
    public float getSensorValue() {
        return sensor_value;
    }

    public void setSensorValue(float sensor_value) {
        this.sensor_value = sensor_value;
    }
    



    //toString

    @Override
    public String toString() {
        return "Sensor Data{" + "id" + id +
                "sensor_status=" + sensor_status +
                ", timestamp='" + timestamp + '\'' +
                ", fk_sensor_id='" + fk_sensor_id + '\''+
                ", sensor_value='" + sensor_value + '\''+
               
                '}';
    }
}
