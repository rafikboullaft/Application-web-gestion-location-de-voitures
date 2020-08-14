<%@ include file="/WEB-INF/views/includes/include.jsp" %>
<!DOCTYPE html>
<html lang="fr">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Reservtions</title>

  <!-- Custom fonts for this template-->
  <link href="<%=request.getContextPath()%>/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="<%=request.getContextPath()%>/resources/css/sb-admin-2.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
  
</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
   <%@ include file="/WEB-INF/views/menu_left/menu_left.jsp" %>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
     <%@ include file="/WEB-INF/views/menu_top/menu_top.jsp" %>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-4 text-gray-800">list de Reservtions</h1>

        </div>
        <!-- /.container-fluid -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary"> Liste des reservations </h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                    <th ><center>voiture</center></th>
                      <th><center>client</center></th>
                      <th><center>Date sortee</center></th>
                       <th><center>Date entree</center></th>
                        <th> <center></center>Action</center></th>
                    </tr>
                  </thead>
                  <tfoot>
                  
                    <tr>
                      <th ><center>voiture</center></th>
                      <th><center>client</center></th>
                      <th><center>Date sortee</center></th>
                       <th><center>Date entree</center></th>
                        <th> <center></center>Action</center></th>
                    </tr>
                  </tfoot>
                  <tbody>
                  <c:forEach items="${reservations}" var="reservation">
               
                    <tr>
                      
                       <td>
                       <center>  
                       
		              <a href="javascript(0)" class="btn btn-success btn-icon-split" data-toggle="modal" data-target="#voitureModall${reservation.getId()}"><span class="icon text-white-50">
		                      <i class="fas fa-plus"></i>
		                    </span>
		                    <span class="text">Voir plus </span> 
		                    </a> 
		                     <div class="modal fade" id="voitureModall${reservation.getId()}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
							  <div class="modal-dialog" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h5 class="modal-title" id="exampleModalLabel">Informations complete sur la voiture réservée</h5>
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
							          <span aria-hidden="true">&times;</span>
							        </button>
							      </div>
							      <div class="modal-body">
							   
							   <c:forEach items="${voitures}" var="voiture">
							     <c:if test="${voiture.getId()==reservation.getIdVoiture()}"> 
							            <h5>Matricule : ${voiture.getMatricule()}</h5>
							            <h5>Modele : ${voiture.getModele()}</h5>
							            <h5>Maeque : ${voiture.getMarque()}</h5>
							            <h5>carburant : ${voiture.getCarburant()}</h5>
							            <h5>Date d'assurance : ${voiture.getAssurance()}</h5>
							            <h5>Date de visite : ${voiture.getVisite()}</h5>
							            <h5>kilometrage : ${voiture.getKilometrage()}</h5>
							            <h5>Prix/J : ${voiture.getPrix()}</h5>
							            <h5>Etat de voiture : ${voiture.isReserver()?"Reserver":"Disponible"}</h5>
							            
							  </c:if>
							     </c:forEach>
							   
							   
							         
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
							         
													      
			                    </div>
							    </div>
							  </div>
							</div>  
		                  
		                  
		                 
		                  </center>
		                  </td>
		              <td>
		              <center>
		                
		              <a href="javascript(0)" class="btn btn-success btn-icon-split" data-toggle="modal" data-target="#voitureModalll${reservation.getId()}"><span class="icon text-white-50">
		                      <i class="fas fa-plus"></i>
		                    </span>
		                    <span class="text">Voir plus </span> 
		                    </a> 
		                     <div class="modal fade" id="voitureModalll${reservation.getId()}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
							  <div class="modal-dialog" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h5 class="modal-title" id="exampleModalLabel">Informations complete sur le client</h5>
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
							          <span aria-hidden="true">&times;</span>
							        </button>
							      </div>
							      <div class="modal-body">
							   
							   <c:forEach items="${clients}" var="client">
							     <c:if test="${client.getId()==reservation.getIdClient()}"> 
							     
							            <h5>Nom : ${client.getNom()}</h5>
							            <h5>Prenom : ${client.getPrenom()}</h5>
							            <h5>Adresse : ${client.getAdresse()}</h5>
							            <h5>Email : ${client.getEmail()}</h5>
							            <h5>Telephone : ${client.getTelephone()}</h5>    
							                  
							      </c:if>
							   </c:forEach>
							   
							   
							         
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
							         
													      
			                    </div>
							    </div>
							  </div>
							</div>  
		                  
		                  
		                 
		              
		              </center>
                  
                  </td>
                      <td><center>${reservation.getDate_sortie()}</center></td>
                      <td><center>${reservation.getDate_entrie()}</center></td>
                      
                 
                   
                      <td>
                      <center> 
                     <c:url value="/reservation/imprimer/${reservation.getId()}" var="contrat"/>
                     <a href="${contrat}" class="btn btn-success btn-icon-split">
                    <span class="icon text-white-50">
                      <i class="fas fa-check"></i>
                    </span>
                    <span class="text">Imprimer</span>
                  </a>
                  
					                  <!-- Button trigger modal -->
					<button type="button" class="btn btn-warning btn-icon-split" data-toggle="modal" data-target="#exampleModalCenter">
					    <span class="icon text-white-50">
                      <i class="fas fa-exclamation-triangle"></i>
                    </span>
                    <span class="text">Supprimer</span>
					</button>
					
					<!-- Modal -->
					<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
					  <div class="modal-dialog modal-dialog-centered" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLongTitle">supprission de la reservation: </h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					     êtes-vous sûr de vouloir supprimer définitivement cette
					      reservation?
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
					        <c:url value="/reservation/supprimer/${reservation.getId()}" var="suppReser"/>
						                  <a href="${suppReser}" class="btn btn-danger btn-icon-split">
						                  
						                    <span class="text">Supprimer</span>
						                  </a>
					      </div>
					    </div>
					  </div>
					</div>
                      </center> 
                      </td>
                    </tr>
                      </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; Your Website 2019</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">Ã—</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
<%--   <script src="<%=request.getContextPath()%>/resources/vendor/jquery-easing/jquery.easing.min.js"></script> --%>

  <!-- Custom scripts for all pages-->
  <script src="<%=request.getContextPath()%>/resources/js/sb-admin-2.min.js"></script>


 

 
  

  <!-- Custom scripts for all pages-->
 

  <!-- Page level plugins -->
  <script src="<%=request.getContextPath()%>/resources/vendor/datatables/jquery.dataTables.min.js"></script>
  <script src="<%=request.getContextPath()%>/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

  <!-- Page level custom scripts -->
 <script src="<%=request.getContextPath()%>/resources/js/demo/datatables-demo.js"></script> 

</body>

</html>
