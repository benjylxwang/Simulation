class Game {
    constructor(charData) {
        this.me = new Character(charData);
        initView();
    }
}

class Character {
    constructor(charData) {
        this.name = charData.name;
        this.attributes = charData.attributes;
    }
}