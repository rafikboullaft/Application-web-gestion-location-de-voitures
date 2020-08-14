<%@ include file="/WEB-INF/views/includes/include.jsp" %>
<!DOCTYPE html>
<html>
  <head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
   </head> 
    <body>  
<style>
 
    body {
       
        /* to centre page on screen*/
        margin-left: auto;
        margin-right: auto;
        background-color: ;  
        text-align:center;
    }
   
    ul {
    list-style: none;
    margin-left: 0;
    padding-left: 0;
    }
    li {
      padding-left: 1.1em;
      text-indent: -1.1em;
    }
    .list1, .list2{
    display: inline-block;
    padding: 15px;
    width:600px; 
    border-style: outset;
    }
    .container{
    diplay:block;
    }
    #header{
    margin:0 25%;
    padding:5px;
    border: solid; border-radius: 15px;
    
    }
    
    
  
       
        
       
    </style>
      
      <div id="header">
          
          <div >
              
              <div style="float: left">
              <img src="<%=request.getContextPath()%>/resources/images/rent-a-car.png" align="center" height='50px' width="50px">  
              <h3 style="display: inline-block ; padding: 0px">AGENCE TOMOBILTI</h3>
              </div>
              
              <div style="display: inline-block; float: right">
              <p style="margin:2px; margin-top: 7px" >Telephone :0500000000 </p>
              <p style="margin: 2px" >Adresse :ENSAH, HOCEIMA </p>
                </div>
            </div>
          
      <h1 align="center" style="font-family: arial; clear: both">Contrat de location de véhicule</h1>
          
      </div>
      
      
      <div align="center"> 
        <p style="font-size: 20px; font-style: italic;display: inline-block"> Date : 08/01/2020 </p>
          <p style="margin-left: 20px;margin-right: 20px;display: inline-block"></p>
        <p style="font-size: 20px; font-style: italic;display: inline-block"> Contrat Numéro : 00001</p>
      </div>
      
      <div class="container">
      
      <div class="list1 responsive green-checkmarks">
      <h3 style="font-family: cursive">Le locataire :</h2>
	  <c:forEach items="${clients}" var="client">
       <ul>
       <li>Nom:${client.getNom()}</li>
       <li>Prenom : ${client.getPrenom()}</li>
       <li>CIN : ${client.getCin()}</li>
       <li>Permis Numéro : ${client.getAdresse()}</li>
       <li>Nationalité: Marocaine</li>
       <li>Telephone : ${client.getTelephone()}</li>
        </ul>
         </c:forEach>
      </div>
      
      <div class="list1 responsive green-checkmarks">
      <h3 style="font-family: cursive">La Véhicule loué :</h2>
      
     
		 <c:forEach items="${voitures}" var="voiture">
		 <ul>
		 <li>Marque :  ${voiture.getMarque()}</li>
		 <li>Modele : ${voiture.getModele()}</li>
		 <li>Immatriculation : ${voiture.getMatricule()}</li>
		 <li>Date Fin Assur. :${voiture.getAssurance()}</li>
		 <li>Kilométrage du depart :  ${voiture.getKilometrage()}</li>
		 <li>Carburant : ${voiture.getCarburant()}</li>
		 </ul>					             
        
        </c:forEach>
      </div>
      <br>
    
          <div class="list2 responsive green-checkmarks">
      <h3 style="font-family: cursive">Deuxieme Chauffeur :</h2>
      <ul>
      <li>Nom : Wld Nas</li>
      <li>Prenom : Flan</li>
      <li>CIN : R000000</li>
      <li>Permis Numéro : 02/055566</li>
      <li>Date De Naissance : 01/01/1999</li>
      <li>Nationalité : Marocaine</li>
      <li>Telephone : 0600000000</li>
      </ul>
      </div>
          
          <div class="list2 responsive green-checkmarks">
      <h3 style="font-family: cursive">Details de location :</h2>
      <c:forEach items="${reservations }" var="reservation">
      	<ul>
      	<li>Date de départ : ${reservation.getDate_sortie()}</li>
      	<li>Date de fin : ${reservation.getDate_sortie()}</li>
      	<li>Prix Total : 2550 Dhs</li>
      	<li>Etat exterieur : Parfait </li>
      	<li>Etat interieur : Parfait</li>
      	<li>Garantie : Oui</li>
      	<li>Roue de secoure : Oui</li>
      	
      	</ul>

        </c:forEach>
      </div>
      </div>    
          
      </div>
      </div>
      <div class="signature">
      <h3>Signature du locataire</h2><br>
       
      <h3>Signature et cachet de societé</h2>
      <br>
    
      <a  href="javascript:window.print()"class="btn btn-secondary" data-dismiss="modal">Imprimer</a>
      </div>

    
   
 
  </body>
</html>