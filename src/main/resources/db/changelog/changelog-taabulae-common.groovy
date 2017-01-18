databaseChangeLog() {
    changeSet(id: 'change-set-tabulae-2', author: 'vladyslav_vinnyk') {

        createTable(tableName: "forms") {
            column(name: "id", type: "BIGINT", autoIncrement: true) {
                constraints(primaryKey: "true")
            }
            column(name: "injectable", type: "VARCHAR") {
                constraints(nullable: "true")
            }
            column(name: "powder_for_injections", type: "VARCHAR") {
                constraints(nullable: "true")
            }
            column(name: "oral_solution", type: "VARCHAR") {
                constraints(nullable: "true")
            }
            column(name: "tablet", type: "VARCHAR") {
                constraints(nullable: "true")
            }
            column(name: "tablet_delayed", type: "VARCHAR") {
                constraints(nullable: "true")
            }
        }
        createTable(tableName: "usage") {
            column(name: "id", type: "BIGINT", autoIncrement: true) {
                constraints(primaryKey: "true")
            }
            column(name: "forms_id", type: "BIGINT") {
                constraints(nullable: "false")
                constraints(foreignKeyName: 'forms_id', references: 'forms')
            }
        }
        createTable(tableName: "dose") {
            column(name: "id", type: "BIGINT", autoIncrement: true) {
                constraints(primaryKey: "true")
            }
            column(name: "disease_name", type: "VARCHAR") {
                constraints(nullable: "true")
            }
            column(name: "dose_description", type: "VARCHAR") {
                constraints(nullable: "true")
            }
            column(name: "usage_id", type: "BIGINT") {
                constraints(nullable: "false")
                constraints(foreignKeyName: 'usage_id', references: 'usage')
            }
        }
        createTable(tableName: "dosing_and_using") {
            column(name: "id", type: "BIGINT", autoIncrement: true) {
                constraints(primaryKey: "true")
            }
            column(name: "adult_id", type: "BIGINT") {
                constraints(nullable: "false")
                constraints(foreignKeyName: 'adult_id', references: 'usage')
            }
            column(name: "pediatric_id", type: "BIGINT") {
                constraints(nullable: "false")
                constraints(foreignKeyName: 'pediatric_id', references: 'usage')
            }
        }
        createTable(tableName: "pregnancy") {
            column(name: "id", type: "BIGINT", autoIncrement: true) {
                constraints(primaryKey: "true")
            }
            column(name: "category", type: "VARCHAR") {
                constraints(nullable: "false")
            }
            column(name: "lactation", type: "VARCHAR") {
                constraints(nullable: "true")
            }
        }
        createTable(tableName: "pharmacology") {
            column(name: "id", type: "BIGINT", autoIncrement: true) {
                constraints(primaryKey: "true")
            }
            column(name: "mechanism_of_action", type: "VARCHAR") {
                constraints(nullable: "true")
            }
            column(name: "absorption", type: "VARCHAR") {
                constraints(nullable: "true")
            }
            column(name: "distribution", type: "VARCHAR") {
                constraints(nullable: "true")
            }
            column(name: "metabolism", type: "VARCHAR") {
                constraints(nullable: "true")
            }
            column(name: "elimination", type: "VARCHAR") {
                constraints(nullable: "true")
            }
        }
        createTable(tableName: "medicine") {
            column(name: "id", type: "BIGINT", autoIncrement: true) {
                constraints(primaryKey: "true")
            }
            column(name: "name", type: "VARCHAR") {
                constraints(nullable: "false")
            }
            column(name: "dosing_and_using_id", type: "BIGINT") {
                constraints(nullable: "false")
                constraints(foreignKeyName: 'dosing_and_using_id', references: 'dosing_and_using')
            }
            column(name: "pregnancy_id", type: "BIGINT") {
                constraints(nullable: "false")
                constraints(foreignKeyName: 'pregnancy_id', references: 'pregnancy')
            }
            column(name: "pharmacology_id", type: "BIGINT") {
                constraints(nullable: "false")
                constraints(foreignKeyName: 'pharmacology_id', references: 'pharmacology')
            }
        }
        createTable(tableName: "adverse_effects") {
            column(name: "id", type: "BIGINT", autoIncrement: true) {
                constraints(primaryKey: "true")
            }
            column(name: "frequency", type: "VARCHAR") {
                constraints(nullable: "false")
            }
            column(name: "description", type: "VARCHAR") {
                constraints(nullable: "true")
            }
            column(name: "medicine_id", type: "BIGINT") {
                constraints(nullable: "false")
                constraints(foreignKeyName: 'medicine_id', references: 'medicine')
            }
        }
    }
}