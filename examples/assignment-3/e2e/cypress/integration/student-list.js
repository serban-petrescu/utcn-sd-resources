describe("The student list", function() {

    beforeEach(function() {
        cy.request("http://localhost:8080/test/reseed")
            .its("status").should("be.equal", 200);
    });

    it("should show three students", function() {
        cy.visit("/");

        cy.get('[data-cy="student"]')
            .should("have.length", 3);
    });

    it('should add a new student', function() {
        cy.visit("/");

        cy.get('[data-cy="add"]').click();

        cy.get('[data-cy="firstName"]').type("Testus");
        cy.get('[data-cy="lastName"]').type("Tester");
        cy.get('[data-cy="create"]').click();

        cy.get('[data-cy="student"]')
            .should("have.length", 4)
            .and("contain", "Testus");
    });

})