package pl.sda.javagdy2.spring.autoservice.model;

public enum Fault {
        KLOCKI_HAMULCOWE ("Klocki hamulcowe"),
        WYMIANA_OPON("Wymiana opon"),
        TARCZE_HAMULCOWE("Tarcze hamulcowe"),
        ROZRZAD ("Rozrząd"),
        SWIECE("Świece"),
        AMORTYZATORY ("Amortyzatory"),
        FILTRY ("Filtry"),
        WYMIANA_OLEJU("Wymiana olej");
        private String description;

        Fault(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
}
