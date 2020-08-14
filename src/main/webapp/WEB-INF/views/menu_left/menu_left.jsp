 <ul style="background-color: #e76f51;" class="navbar-nav  sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-car-side"></i>
        </div>
        <div class="sidebar-brand-text mx-3">TOMOBILTI<sup>rent-a-car</sup></div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
      <li class="nav-item">
        <c:url value="/dashboard/" var="dashboard"/>
            <a class="nav-link" href="${dashboard}">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>dableau de bord</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        Gestion
      </div>

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-car-alt"></i>
          <span>Gestion de voitures</span>
        </a>
        <div id="collapseOne" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            
             <c:url value="/voiture/" var="voiture"/>
            <a class="collapse-item" href="${voiture}">Liste des voitures</a>
                 <c:url value="/voiture/VoituresResevees/" var="voituresResv"/>        
            <a class="collapse-item" href="${voituresResv}">Liste des voitues réservées</a>
          </div>
        </div>
      </li>

      <!-- Nav Item - Utilities Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-users"></i>
          <span>Gestin des clients</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            
             <c:url value="/client/" var="client"/>
            <a class="collapse-item" href="${client}">Clients</a>
            <c:url value="/client/nouveau" var="client_2"/>
            <a class="collapse-item" href="${client_2}">Ajouter clients</a>
          </div>
        </div>
      </li>
      
                <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseThree" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-file-alt"></i>
          <span>Gestion de reservations</span>
        </a>
        <div id="collapseThree" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            
              <c:url value="/reservation/" var="reservation"/>
            <a class="collapse-item" href="${reservation}">Liste des Deservations</a>
            <c:url value="/voiture/" var="voiture"/>
            <a class="collapse-item" href="${voiture}">Reserver</a>
          </div>
        </div>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        TOMOBILTI
      </div>

      <!-- Nav Item - Pages Collapse Menu -->
     

      <!-- Nav Item - Charts -->
      <li class="nav-item">
        <a class="nav-link" href="${dashboard}">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Statistiques</span></a>
      </li>

      <!-- Nav Item - Tables -->
      <li class="nav-item">
      <c:url value="/dashboard/Alert" var="alert"/>
        <a class="nav-link" href="${alert}">
          <i class="fas fa-bell"></i>
          <span>Alert</span></a>
      </li>
      <li class="nav-item">
      <c:url value="/reservation/today" var="today"/>
        <a class="nav-link" href="${today}">
          <i class="fas fa-thumbtack"></i>
          <span>Ajourd'hui</span></a>
      </li>
      

      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>