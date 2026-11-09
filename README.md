# Café Express

Application Android (Kotlin) de prise de commande pour un café. Mini-projet du module Développement mobile, ISTA NTIC Safi.

## Fonctionnalités

- Choix des quantités de Café (10 DH), Thé (8 DH) et Croissant (6 DH) avec les boutons + et −
- Quantités jamais négatives
- Total mis à jour à chaque clic
- Nom du client obligatoire pour commander
- Bouton **Vider** : remet tout l'écran à zéro
- Bouton **Commander** : ouvre l'écran Récapitulatif
- Écran **Récapitulatif** : affiche le client, le détail de chaque produit et le total
  - **Modifier** : revient au formulaire avec la commande intacte
  - **Confirmer** : affiche un Toast puis revient au formulaire

## Structure du projet

| Fichier | Rôle |
|---|---|
| `MainActivity.kt` | Écran de commande (formulaire) |
| `Main2Activity.kt` | Écran Récapitulatif |
| `activity_main.xml` | Layout du formulaire (LinearLayout) |
| `activty2.xml` | Layout du récapitulatif (ConstraintLayout) |
| `AndroidManifest.xml` | Déclaration des deux Activities |

## Passage de données entre les écrans

`MainActivity` envoie la commande avec un `Intent` et `putExtra`, puis `Main2Activity` la lit avec `getStringExtra` et `getIntExtra`.

| Clé | Type | Contenu |
|---|---|---|
| `NOM_CLIENT` | String | Nom du client |
| `QTE_CAFE` | Int | Quantité de cafés |
| `QTE_THE` | Int | Quantité de thés |
| `QTE_CROISSANT` | Int | Quantité de croissants |
| `TOTAL` | Int | Total en DH |

Les clés doivent être écrites exactement pareil dans les deux fichiers.

## Installation

1. Copier `MainActivity.kt` et `Main2Activity.kt` dans `app/src/main/java/com/example/cafe001/`
2. Copier `activity_main.xml` et `activty2.xml` dans `app/src/main/res/layout/`
3. Ajouter dans `AndroidManifest.xml`, à l'intérieur de `<application>` :

```xml
<activity
    android:name=".Main2Activity"
    android:exported="false" />
```

4. Lancer l'application depuis Android Studio (émulateur ou téléphone)

## Tests

- 2 cafés + 1 thé + 1 croissant = 34 DH
- Commander sans nom : erreur sur le champ
- Commander avec un nom mais sans article : Toast « Le panier est vide »
- Commander une commande complète : ouverture du récapitulatif
- Modifier : retour au formulaire, commande conservée
- Vider : tout remis à zéro
