Proxibanque V4.0:
*****************
Membres : 

Widad Cadi / Zineb Sidelkhir / Rabie Habachi / Ismail Norri / Mohamed Bourkha;

==================================================================================

I/Introduction:

Proxibanque est une application con�ue pour :

#Le g�rant de l'agence bancaire afin de lui permettre la gestion des conseillers client�les.
#Les conseillers afin de leur permettre la gestion de leurs portefeuilles clients et leurs comptes bancaires.
#Param�trage afin de lui permettre le parametrage de nombre clients affecter au conseillers et le nombre de conseillers affecter aux gerant

==================================================================================

II/Fonctionnalit�s:


L'application permet de r�aliser les op�rations suivantes :


Pour le g�rant:
*************** 
	- Ajouter un conseiller;
	- Consulter la liste des clients non affect�s;
	- Affecter un client non affect� � un conseiller;
	- Consulter le rapport des transactions de la semaine ou des 6 derniers mois.
	- Consulter la liste des conseillers dont les clients sont � d�couvert.

Pour le conseiller:
*************** 
	- Ajouter un client;
	- SUpprimer un client;
	- Modifier un client;
	- Consulter la liste des clients;
	- Consulter les comptes d'un client ;
	- Effectuer un virement d'un montant d'un compte vers un autre, c'est-�-dire, retirer
      	  le montant du compte et le verser vers l'autre compte :
		Pour un compte courant, le retrait peut s'effectuer � condition que le solde final ne soit pas inf�rieur au d�couvert.
	-Consulter la liste des clients qui sont � d�couvert

Pour le Param�trage
*************** 
	- Modifier comission d'un conseiller
	- Modifier nombre clients d'un conseiller
	- Modifier nombre conseillers d'un gerant
	- Modifier style de graphe (histogramme,camambert)(en cours...)



	#Chaque compte est d�fini par un num�ro, un solde et une date de cr�ation ;
	#Il existe deux types de comptes : les comptes courants et les comptes �pargnes ;
	#Un compte courant est un compte qui poss�de en plus un d�couvert ;
	#Un compte �pargne est un compte qui poss�de en plus un taux de r�muneration ;
	#Chaque compte appartient � un client et cr�� par un conseiller;
	#Chaque client est d�fini par son id, son nom et prenom, son adresse, sa ville, son t�l�phone et un code postal;
	#Un conseiller est cr�� par le g�rant, et est d�fini aussi par son id et son nom et prenom, son adresse,son email et son login et mot de passe;
	#Chaque compte peut subir une op�ration de virement;	#Chaque compte peut subir une op�ration de virement;


==================================================================================

III/Installation:

Les diagrammes de classes de cas d'utilisation et de d�ploiement ainsi que le sql et les maquettes sont dans le dossier "conception"
Pour utiliser ProxiBanqueSI V4.0 : 

======== Installer l'application ========

1) d�ziper dans un dossier le fichier "ProxiBanqueV4.zip"
2) ouvrir une console
3) aller jusqu'au dossier src de proxibanque.
4) taper : mvn clean package 
6) puis : target\proxiBanqueV4.war S:\apache-tomcat-9\webapps\ProxiBanqueV4.war

======== Cr�er la base de donn�e MySQL ========

1) Ouvrir Xampp
2) Lancer Apache
3) Lancer MySQL
4) Lancer le controle Admin de MySQL sur Xampp
5) Cliquer sur l'onglet "console" de Xampp
6) taper : "mysql -u root -p" puis tapez [entr�e]
7) Ouvrir le dossier conception et ouvrez dans un �diteur texte le fichier "proxibanqueversion4.sql"
8) Copier l'enti�ret� du fichier
9) Dans la console, coller le texte copi�.
10) La base de donn�e a �t� cr�e dans MySQL.

======== Lancer l'application ========

1) Lancer serveur d'application 
2)Sur le terminal d'un �diteur de texte (VisualCode) lancez la commande "npm install -g @angular/cli"

3)Ouvrez le dossier FrontEndPBqV4-master dans un �diteur de texte (VisualCode)

4)Lancez la commande npm start

5) Ouvrez un navigateur internet
6) Tapez dans l'url : http://localhost:4200/

==================================================================================

IV_Utilisation
;
Au d�marrage l'application ProxiBanqueV4 affiche une page d'accueil avec trois espaces (g�rant, conseiller, param�trage).

Pour le g�rant:
*************** 

	- cliquez sur acc�der. Une page d'authentification s'affiche o� un login et un mot de passe sont demand�s.

Par d�faut 1 seul g�rant de l'agence  a �t� d�finit avec:
 
		#login: jawad@gmail.com;
		#mot de passe : jawad.

Si le login ou le mot de passe est incorrect, un message vous demandant de vous connecter avec de bons param�tres d'identification appara�tra.

=== Une fois identifi� ===

Une page "Liste des conseillers" vous liste les conseillers existants dans l'agence avec leur informations. Pour chaque conseiller se trouve 
un bouton "Affecter Client".

Le nom et pr�nom du g�rant est alors affich� dans la barre de navigation ainsi que les boutons "Ajouter Conseiller" et "Rapport de transactions"


	[Ajouter Conseiller]

	        #En renseignant le formulaire qui appara�t apr�s avoir cliquer sur le bouton "Ajouter" vous pouvez cr�er un nouveau conseiller.
		#Une fois le bouton [Ajouter] cliqu�, la page d'accueil est mise � jour et le nouveau client apparait dans le tableau.
Si l'un des champs n'est pas rempli, un message vous demandant de remplir tous les champs  appara�tra.
		
        [Affecter Client]
 
		# Une fois cliqu� une nouvelle page vous affiche la liste des clients non affect�s.
		# En cliquant sur le bouton + se trouvant dans la ligne d'un client non affect�, il sera automatiquement affect� au conseiller de d�part.
		# Le client sera ajout� � la liste des clients du conseiller.
		
	[Rapport de transactions]

		# Une fois cliqu� une nouvelle page vous affiche le rapport des transactions de la semaine, et un bouton "Transaction/6mois" vous permettra 
		  de voir le rapport sur les 6 derniers mois.
		
	[Suppression]

		#Une fois cliqu�, le conseiller est supprim� de la liste et de la Base de Donn�e.
Un message vous demandant de valider la supression appara�tra.

	[Alerte]

		#Une alerte est affich�e dans la barre de navigation du g�rant d�s sa connexion si l'un des conseillers a un client � d�couvert.
		#En cliquant dessus, une liste contenant les conseillers ayant des clients � d�couvert s'affiche.


A chaque �tape de votre navigation, le bouton Proxibanque vous permettra de vous revenir � la page principal qui est la liste des conseillers.
A chaque �tape de votre navigation, le bouton [Logout] bleu vous permettra de vous deconnecter et de revenir � l'accueil.


Pour le conseiller:
*******************

	- cliquez sur acc�der. Une page d'authentification s'affiche o� un login et un mot de passe sont demand�s.

Par d�faut 2 conseillers de client�le ont �t� d�finis avec 
	- conseiller 1:
		# login :"zineb@gmail.com"			
		# password "zinebproxi"
	- conseiller 2:
		# login :"mouhamed@gmail.com"			
		# password "mouhamedproxi"

Si le login ou le mot de passe est incorrect, une page vous demandant de vous connecter avec de bons param�tres d'itentification appara�tra. 


    
=== Une fois identifi� ===

Une page "Liste des clients" vous liste les clients qui sont associ�s au conseiller connect� avec leurs informations, ainsi que les op�rations
pouvant �tre effectu�es pour chaque client.
Le nom et pr�nom du conseiller sont alors affich�s dans la barre de navigation ainsi que les boutons "Ajouter Client" et "Effectuer virement".

Plusieurs choix s'offrent � vous :

	[Ajouter Client]

	        #En renseignant le formulaire qui appara�t apr�s avoir cliquer sur le bouton "Ajouter" vous pouvez cr�er un nouveau client.
		#Une fois le bouton [Ajouter] cliqu�, la page d'accueil est mise � jour et le nouveau client apparait dans le tableau.
Si l'un des champs n'est pas rempli, un message vous demandant de remplir tous les champs  appara�tra.
		
        [Modifier Client] 

		#Une fois le bouton cliqu� une nouvelle page apparait vous affichant les caract�ristiques du client. 
		#Il vous est alors possible de modifier ses caract�ristiques � partir du formulaire puis en cliquant sur le bouton [Modifier]
		Vous retournez au menu principal "Liste des Clients".
		
        [Liste des comptes] 
		# Une fois cliqu� une nouvelle page vous affiche la liste des comptes du clients tri� par Compte Courant et Compte Epargne.
		
	[Virements] 
		# Une fois cliqu� une nouvelle page de virement s'affiche.
		# Vous pouvez effectuer des virements comptes � comptes avec le formulaire : 
			- s�lectionner le compte � d�biter
			- s�lectionner le compte � cr�diter
			- s�lectionner le montant
			- cliquer sur [effectuer le virement]
			- La page est alors mise � jour avec un message de validation.
		# Pour revenir � la liste des clients cliquez sur l'onglet "Liste des Clients" au centre de la page.
Si le montant du compte � d�biter est inf�rieur au montant de la transaction, un message d'erreur s'affichera.
Si l'un des champs n'est pas rempli, un message vous demandant de remplir tous les champs  appara�tra.
		
	[Suppression]

		#Une fois cliqu�, le client est supprim� de la liste et de la Base de Donn�e.
A chaque �tape de votre navigation, le bouton Proxibanque vous permettra de vous revenir � la page principal qui est la liste des clients.
A chaque �tape de votre navigation, le bouton [Logout] bleu vous permettra de vous deconnecter et de revenir � l'accueil de l'application.

Pour le param�trage: 
*******************

	- cliquez sur acc�der. Une page d'authentification s'affiche o� un login et un mot de passe sont demand�s.

Par d�faut un login et un mot de passe ont �t� d�finit pour l'administrateur charg� de parametrer l'application
	
		# login :"parametrage@gmail.com"			
		# password "mako"


Si le login ou le mot de passe est incorrect, une page vous demandant de vous connecter avec de bons param�tres d'itentification appara�tra. 

    
=== Une fois identifi� ===

	        #Une page de param�tres est affich�.
		#Vous pouvez alors les modifier, ou cliquer sur le bouton "Param�tres par d�faut" , pour revenir aux param�tres par d�faut.
		#Une fois cliqu� sur modifi�, la page est mise � jour avec un message de validation.
Le bouton [Logout] bleu vous permettra de vous deconnecter et de revenir � l'accueil de l'application.

## V_EVOLUTIONS
    - Dans de futures versions, l'application pourra proposer � ses acteurs d'autres fonctionnalit�s telle que la gestion des patrimoines et calcul de cr�dit.

===========================================================================

L'application respecte les crit�res suivants :
Elle se compose de trois couches : Entites,DAO, Metier;
L'invertion de controle avec Spring IOC 
La Couche Service : EJB sauf le virement qui est un WebService REST;
La Base de donn�es est MySQL;
L'acc�s aux donn�es avec JPA;
Le serveur d�application utilis� est Tomcat.
La partie FrontEnd avec le framework Angular
La partie log avec log4J
