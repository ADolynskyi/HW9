package org.example;




import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import jakarta.persistence.*;
import org.example.data_base_entities.Apartment;
import org.example.data_base_entities.Building;
import org.example.data_base_entities.ResidentApartment;

import java.util.List;


public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("OsbbPersistenceUnit");
        EntityManager entityManager =entityManagerFactory.createEntityManager();


        List<Building> buildingNativeSql = building_processedWithNativeSQL(entityManager);
        for(Building building: buildingNativeSql){
            System.out.println(building.getName());
            System.out.println(building.getStreet());
            System.out.println(building.getNumber());
            for(Apartment apartment: building.getApartment()){
                System.out.println("\t:" +apartment.getId()+" Area:" +apartment.getArea());
                for(ResidentApartment residentApartment: apartment.getResidentApartments()){
                    System.out.println(residentApartment.getOwnership());
                }
            }
        }

    }
    static List<Building> building_processedWithNativeSQL(EntityManager entityManager){
        Query query =entityManager.createNativeQuery(
                "SELECT * FROM buildings b WHERE building_id=4",
                Building.class);
        return query.getResultList();
    }
}
