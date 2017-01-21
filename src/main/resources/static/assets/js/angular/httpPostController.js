var drugs = angular.module("editMedicine", ['medicineService', 'ngCookies']);

drugs.controller("createMedicine", function($http, $scope, $cookies) {
	$scope.inputdosingAndUsing = {
		adult : {
			doses : [],
			forms : {}
		},
		pediatric : {
			doses : [],
			forms : {}
		}
	};
	$scope.inputAadverseEffects = [];

	$scope.inputPharmacology = {
		absorption : "",
		distribution : "",
		elimination : "",
		mechanismOfAction : "",
		metabolism : ""
	};

	$scope.inputPregnancy = {
	};

	$scope.SendData = function() {
		// use $.param jQuery function to serialize data from JSON
		var medicineDto = {
			adverseEffects : $scope.inputAadverseEffects,
			dosingAndUsing : $scope.inputdosingAndUsing,
			name : $scope.medicineName,
			pharmacology : $scope.inputPharmacology,
			pregnancy : $scope.inputPregnancy
		};

		$scope.medicineDto = medicineDto;


        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");

        console.log(token);
        console.log(header);

		var req = {
         method: 'POST',
         url: '/medicine',
         headers: {
           "X-CSRF-TOKEN": token
         },
         data: medicineDto
        }

		$http(req).then(function(response) {
		    deferred.resolve(response.data);
		}, function(errResponse) {
		    console.error('Error while creating User');
		    deferred.reject(errResponse);
		});
	};

	//Adverse Effects
	$scope.frequency = ['MORE_TEN', 'ONE_TO_TEN', 'LESS_ONE', 'POSTMARKETING_REPORTS'];

	//Doses
	$scope.addDose = function(dose, type) {
		if ('adult' === type) {
			for ( i = 0; i < $scope.inputdosingAndUsing.adult.doses.length; i++) {
				var doseSaved = $scope.inputdosingAndUsing.adult.doses[i];
				if (doseSaved === dose) {
					$scope.inputdosingAndUsing.adult.doses[i] = dose;
					return;
				}
			}
			$scope.inputdosingAndUsing.adult.doses.push(dose);
		}

		if ('pediatric' === type) {
			for ( i = 0; i < $scope.inputdosingAndUsing.pediatric.doses.length; i++) {
				var doseSaved = $scope.inputdosingAndUsing.pediatric.doses[i];
				if (doseSaved === dose) {
					$scope.inputdosingAndUsing.pediatric.doses[i] = dose;
					return;
				}
			}
			$scope.inputdosingAndUsing.pediatric.doses.push(dose);
		}
	};

	//Add Adverse Effects
	$scope.addAdverse = function(adverse) {
		var frequency = adverse.frequency;

		for ( i = 0; i < $scope.inputAadverseEffects.length; i++) {
			var inputAdverse = $scope.inputAadverseEffects[i];
			if (inputAdverse.frequency === adverse.frequency) {
				$scope.inputAadverseEffects[i] = adverse;
				return;
			}
		}
		$scope.inputAadverseEffects.push(adverse);
	};

	$scope.adultDosestextAreas = [{
		textBox : ""
	}];
	//Add Adult Doses
	$scope.addMoreAdultDoses = function() {
		$scope.adultDosestextAreas.push({
			textBox : ""
		});
	};
	//Delete Adult Doses
	$scope.deleteLastAdultDoses = function() {
		$scope.inputdosingAndUsing.adult.doses.pop();
		$scope.adultDosestextAreas.pop();
	};

	$scope.pediatricDosestextAreas = [{
		textBox : ""
	}];
	//Add Pediatric Doses
	$scope.addMorePediatricDoses = function() {
		$scope.pediatricDosestextAreas.push({
			textBox : ""
		});
	};
	//Delete Pediatric Doses
	$scope.deleteLastPediatricDoses = function() {
		$scope.inputdosingAndUsing.pediatric.doses.pop();
		$scope.pediatricDosestextAreas.pop();
	};
	
	//Pregnancy Categotries
	$scope.categories = ['A', 'B', 'C', 'D'];
	
	//Add Pregnancy
	$scope.addPregnancy = function(adverse) {
		$scope.inputPregnancy = adverse;
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

