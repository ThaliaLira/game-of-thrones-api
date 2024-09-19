package com.gameofthrones.tbotit.enums;

public enum Words {

    HOUSE_STARK("Winter is Coming"),                   // O Inverno Está Chegando
    HOUSE_LANNISTER("Hear Me Roar!"),                  // Ouça-me Rugir!
    HOUSE_TARGARYEN("Fire and Blood"),                 // Fogo e Sangue
    HOUSE_BARATHEON("Ours is the Fury"),               // Nossa é a Fúria
    HOUSE_GREYJOY("We Do Not Sow"),                    // Nós Não Semeamos
    HOUSE_MARTELL("Unbowed, Unbent, Unbroken"),        // Não Curvados, Não Quebrados, Não Submissos
    HOUSE_TYRELL("Growing Strong"),                    // Crescendo Fortes
    HOUSE_BOLTON("Our Blades Are Sharp"),              // Nossas Lâminas São Afiadas
    HOUSE_FREY("We Stand Together"),                   // Nós Ficamos Juntos
    HOUSE_TULLY("Family, Duty, Honor"),                // Família, Dever, Honra
    HOUSE_ARRYN("As High as Honor"),                   // Tão Alto Quanto a Honra
    HOUSE_MORMONT("Here We Stand"),                    // Aqui Estamos
    HOUSE_TARLY("First in Battle"),                    // Primeiro na Batalha
    HOUSE_HIGHTOWER("We Light the Way"),               // Nós Iluminamos o Caminho
    HOUSE_CARSTARCK("The Sun of Winter"),              // O Sol do Inverno
    HOUSE_REED("We Remember"),                         // Nós Lembramos
    HOUSE_HORNWOOD("Righteous in Wrath"),              // Justo na Ira
    HOUSE_DAYNE("Sword of the Morning"),               // Espada da Manhã
    HOUSE_BLACKWOOD("Wolves of the Woods"),            // Lobos das Florestas
    HOUSE_CLEGANE("Strength and Honor");               // Força e Honra

    private final String words;

    Words(String words) {
        this.words = words;
    }


    public String getWords() {
        return this.words;
    }
}
}
