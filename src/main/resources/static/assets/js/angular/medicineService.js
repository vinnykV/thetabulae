var medicine = angular.module('medicineService', [])
medicine.constant("CSRF_TOKEN", '{{ csrf_token() }}');