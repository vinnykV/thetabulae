var drugs = angular.module("medicine", []);

drugs.controller("medicine", function($http, $scope) {
	//Set up Default Menu at start.
	$scope.menu = {
		dosingUsing : true,
		showAdverse : false,
		pregnancy : false,
		pharmacology : false,
		patientInfo : false
	};

	//Request of the medicine from REST.
	$http.get("http://localhost:8090/medicine/15").then(function(response) {
		$scope.medicine = response.data;
		$scope.dosingUsing = $scope.medicine.dosingAndUsing.adult;
	});

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
