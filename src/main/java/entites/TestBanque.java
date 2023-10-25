package entites;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestBanque {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            //Création des clients
            Adresse adresse = new Adresse();
            adresse.setCodePostal(26250);
            adresse.setNumero(11);
            adresse.setRue("Le clos mistral");
            adresse.setVille("Livron");
                       
            Client client1 = new Client();
            client1.setNom("Le Moal");
            client1.setPrenom("Theo");
            client1.setDateNaissance(new Date());
            client1.setAdresse(adresse);
            
            Client client2 = new Client();
            client2.setNom("Doe");
            client2.setPrenom("Jhon");
            client2.setDateNaissance(new Date());
            client2.setAdresse(adresse);

            //Création d'une banque et ajout de la banque au clients
            Banque banque = new Banque();
            client1.setBanque(banque);
            client2.setBanque(banque);
            List<Client> clients = new ArrayList<Client>();
            clients.add(client1);
            clients.add(client2);
            banque.setNom("Caisse d'épargne");
            banque.setClients(clients);
            
            //Création de 2 comptes (1 assurance vie et 1 livret A)
            //Assurance vie
            AssuranceVie assurance = new AssuranceVie();
            assurance.setNumero("00001");
            assurance.setSolde(100);
            assurance.setDatefin(new Date(124, 9, 23));
            
            //Livret A
            Compte livret = new LivretA();
            livret.setNumero("00001");
            livret.setSolde(100);

            //insérer un compte associé à 2 clients
            clients = new ArrayList<Client>();
            clients.add(client1);
            clients.add(client2);
            livret.setClients(clients);
            
            //insérer un client avec plusieurs comptes
            List<Compte> comptes = new ArrayList<Compte>();
            comptes.add(livret);
            comptes.add(assurance);
            client1.setComptes(comptes);

            //Insérer des opérations de type operation dans un compte
            Operation operation1 = new Operation();
            operation1.setDate(new Date());
            operation1.setMontant(50);
            operation1.setMotif("Je dois le faire pour le tp");
            operation1.setCompte(livret);
            
            Operation operation2 = new Operation();
            operation2.setDate(new Date());
            operation2.setMontant(50);
            operation2.setMotif("Je dois le faire pour le tp");
            operation2.setCompte(livret);
            
            List<Operation> operations = new ArrayList<Operation>();
            operations.add(operation1);
            operations.add(operation2);
            livret.setOperations(operations);
            
            //insérer des opérations de type virements sur un compte
            Virement virement1 = new Virement();
            virement1.setDate(new Date());
            virement1.setMontant(50);
            virement1.setMotif("Je dois le faire pour le tp");
            virement1.setCompte(livret);
            virement1.setBenificiaire("Un chic type");
            
            Virement virement2 = new Virement();
            virement2.setDate(new Date());
            virement2.setMontant(50);
            virement2.setMotif("Je dois le faire pour le tp");
            virement2.setCompte(livret);
            virement2.setBenificiaire("Quelqun");
            
            List<Operation> virements = new ArrayList<Operation>();
            virements.add(virement1);
            virements.add(virement2);
            livret.setOperations(virements);
            
            //On envoie en base de données
            em.persist(client1);
            em.persist(client2);
            em.persist(banque);
            em.persist(livret);
            em.persist(assurance);
            em.persist(operation1);
            em.persist(operation2);
            em.persist(virement1);
            em.persist(virement2);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
