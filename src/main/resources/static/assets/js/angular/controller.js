var drugs = angular.module("readMedicine", ['medicineService']);

drugs.controller("allMedicines", function($http, $scope, $rootScope) {

      	//Request of the medicine from REST.
      	$http.get("/medicine/" + "all").then(function(response) {
      		$scope.medicines = response.data;
      	});
      });

drugs.controller("medicine", function($http, $scope, $rootScope) {
    $scope.$watch('medicineId', function () {
        $scope.var2 = $scope.medicineId;

        //Request of the medicine from REST.
        $http.get("/medicine/" + $scope.var2).then(function(response) {
        	$scope.medicine = response.data;
        	$scope.dosingUsing = $scope.medicine.dosingAndUsing.adult;
        });
    });
    var medicineId = getMedicineId();

	//Set up Default Menu at start.
	$scope.menu = {
		dosingUsing : true,
		showAdverse : false,
		pregnancy : false,
		pharmacology : false,
		patientInfo : false
	};



	//Switch dosing and using. Adult to Pediatrics.
	$scope.isAdultDosing = true;
	$scope.switchDosingUsing = function() {
		if ($scope.isAdultDosing) {
			$scope.dosingUsing = $scope.medicine.dosingAndUsing.adult;
		} else {
			$scope.dosingUsing = $scope.medicine.dosingAndUsing.pediatric;
		}
	};
});

drugs.filter('capitalize', function() {
	return function(input) {
		return (!!input) ? input.charAt(0).toUpperCase() + input.substr(1).toLowerCase() : '';
	};
});

drugs.filter('convertFrequencyEnum', function() {
	return function(input) {
		if (!!input) {
			if ('MORE_TEN' === input) {
				return '>10%';
			}
			if ('ONE_TO_TEN' === input) {
				return '1-10%';
			}
			if ('LESS_ONE' === input) {
				return '<10%';
			}
			if ('POSTMARKETING_REPORTS' === input) {
				return 'Postmarketing reports';
			}
		}
		return '';
	};
});

function getMedicineId() {
    var url = window.location.href;

    var parts = url.split("/");
    var result = parts[parts.length - 1];

    if(!Number.isInteger(result)) {
              result = "";
    }

    return result;
}