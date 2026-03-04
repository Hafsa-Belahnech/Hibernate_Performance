package com.example.service;

import com.example.model.Auteur;
import com.example.model.Categorie;
import com.example.model.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Arrays;
import java.util.List;

public class DataInitService {

    private final EntityManagerFactory emf;

    public DataInitService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void initData() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            // Création des catégories
            Categorie nouvelle = new Categorie("Nouvelle", "Œuvres caractérisées par une intrigue concentrée, peu de personnages et souvent une chute inattendue");
            Categorie scienceFiction = new Categorie("Science-Fiction", "Œuvres spéculatives basées sur des innovations scientifiques");
            Categorie fantasy = new Categorie("Fantasy", "Œuvres mettant en scène un univers imaginaire");
            Categorie policier = new Categorie("Policier", "Œuvres centrées sur la résolution d'une enquête");
            Categorie biographie = new Categorie("Biographie", "Récits de vie de personnalités");

            em.persist(nouvelle);
            em.persist(scienceFiction);
            em.persist(fantasy);
            em.persist(policier);
            em.persist(biographie);

            // Création des auteurs et de leurs livres
            Auteur auteur1 = new Auteur("Mérimée", "Prosper", "prosper.mérimée@example.com");
            Livre livre1 = new Livre("La Vénus d’Ille", 1837, "9782253096344");
            livre1.setResume("L'histoire d'un archéologue visite le Roussillon pour voir une statue de Vénus en bronze.");
            livre1.addCategorie(nouvelle);

            Livre livre2 = new Livre("La Chambre bleue", 1866, "9782253096337");
            livre2.setResume("Une nouvelle de mystère écrite pour l'impératrice Eugénie");
            livre2.addCategorie(nouvelle);

            auteur1.addLivre(livre1);
            auteur1.addLivre(livre2);

            Auteur auteur2 = new Auteur("Asimov", "Isaac", "isaac.asimov@example.com");
            Livre livre3 = new Livre("Fondation", 1951, "9782070415700");
            livre3.setResume("L'histoire de la Fondation, créée pour préserver la civilisation galactique.");
            livre3.addCategorie(scienceFiction);

            Livre livre4 = new Livre("Les Robots", 1950, "9782290055120");
            livre4.setResume("Recueil de nouvelles sur les robots et les Trois Lois de la robotique.");
            livre4.addCategorie(scienceFiction);

            auteur2.addLivre(livre3);
            auteur2.addLivre(livre4);

            Auteur auteur3 = new Auteur("Tolkien", "J.R.R.", "jrr.tolkien@example.com");
            Livre livre5 = new Livre("Le Seigneur des Anneaux", 1954, "9782070612888");
            livre5.setResume("L'épopée de Frodon Sacquet pour détruire l'Anneau Unique.");
            livre5.addCategorie(fantasy);

            Livre livre6 = new Livre("Le Hobbit", 1937, "9782075134156");
            livre6.setResume("Les aventures de Bilbon Sacquet, recruté par le magicien Gandalf.");
            livre6.addCategorie(fantasy);

            auteur3.addLivre(livre5);
            auteur3.addLivre(livre6);

            Auteur auteur4 = new Auteur("Christie", "Agatha", "agatha.christie@example.com");
            for (int i = 1; i <= 20; i++) {
                Livre livre = new Livre("Mystère " + i, 1920 + i, "978020000000" + i);
                livre.setResume("Un mystère à résoudre par Hercule Poirot ou Miss Marple.");
                livre.addCategorie(policier);
                auteur4.addLivre(livre);
            }

            em.persist(auteur1);
            em.persist(auteur2);
            em.persist(auteur3);
            em.persist(auteur4);

            em.getTransaction().commit();
            System.out.println("Données initialisées avec succès !");

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Auteur> getAuteurs() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT a FROM Auteur a", Auteur.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Categorie> getCategories() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Categorie c", Categorie.class).getResultList();
        } finally {
            em.close();
        }
    }
}
