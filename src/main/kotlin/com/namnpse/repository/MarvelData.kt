package com.namnpse.repository

import com.namnpse.models.Hero

val marvelHeroes = listOf(
    Hero(
        id = 1001,
        name = "Wolverine",
        image = "/images/marvel/wolveriner.jpeg",
        about = "A long-lived mutant with the rage of a beast and the soul of a Samurai, James \"Logan\" Howlett's once mysterious past is filled with blood, war, and betrayal. Possessing an accelerated healing factor, keenly enhanced senses, and bone claws in each hand (along with his skeleton) that are coated in adamantium; Wolverine is, without question, the ultimate weapon.",
        rating = 5.0,
        power = 98,
        abilities = listOf(
            "Agility",
            "Claws",
            "Enhance Mutation",
            "Healing",
            "Immortal"
        ),
        gender = "Male",
        issues = 15654,
        realName = "James Howlett",
        aliases = listOf(
            "James Howlett",
            "Logan",
            "Weapon X",
            "Black Dragon"
        ),
        collection = "Marvel"
    ),
    Hero(
        id = 1002,
        name = "Captain America",
        image = "/images/marvel/captain-america.jpeg",
        about = "During World War II, Steve Rogers volunteered to receive the experimental Super-Soldier Serum. Enhanced to the pinnacle of human physical potential and armed with an unbreakable shield, he became Captain America. After a failed mission left him encased in ice for decades, he was found and revived by the Avengers, later joining their ranks and eventually becoming the team's leader.",
        rating = 5.0,
        power = 98,
        aliases = listOf(
            "Steve Rogers",
            "Super-Soldier",
            "The Captain",
            "Roger Grant",
            "First Avenger"
        ),
        issues = 11331,
        abilities = listOf(
            "Adaptive",
            "Agility",
            "Energy Shield",
            "Leadership",
            "Gadgets"
        ),
        realName = "Steven Grant Rogers",
        collection = "Marvel"
    ),
    Hero(
        id = 1003,
        name = "Hulk",
        image = "/images/marvel/hulk.jpeg",
        about = "After being bombarded with a massive dose of gamma radiation while saving a young man's life during an experimental bomb testing, Dr. Robert Bruce Banner was transformed into the Incredible Hulk: a green behemoth who is the living personification of rage and pure physical strength.",
        rating = 5.0,
        power = 98,
        realName = "Robert Bruce Banner",
        aliases = listOf(
            "Bruce Banner",
            "The Incredible Hulk",
            "Dr. Banner",
            "Immortal Hulk"
        ),
        issues = 7524,
        abilities = listOf(
            "Adaptive",
            "Agility",
            "Healing",
            "Immortal",
            "Radiation",
            "Energy Absorption"
        ),
        collection = "Marvel"
    ),
    Hero(
        id = 1004,
        name = "Invisible Woman",
        image = "/images/marvel/invisible-woman.jpeg",
        about = "Susan Storm is a founding member of the Fantastic Four and later the Future Foundation. She is able to create invisible force fields of any shape she conceives and able to turn herself and anything she's in contact with invisible. Sue is the wife of Reed Richards and the mother of their children, Franklin and Valeria.",
        rating = 4.5,
        power = 92,
        realName = "Susan Storm Richards",
        aliases = listOf(
            "Dr Susan Storm",
            "Invisible Girl",
            "Marvel's First Lady",
            "Sue Storm"
        ),
        issues = 6013,
        abilities = listOf(
            "Agility",
            "Blast Power",
            "Invisibility",
            "Invulnerability"
        ),
        gender = "Female",
        collection = "Marvel"
    ),
    Hero(
        id = 1005,
        name = "Spider Man",
        image = "/images/marvel/spider-man.jpeg",
        about = "Peter Parker was bitten by a radioactive spider as a teenager, granting him spider-like powers. After the death of his Uncle Ben, Peter learned that \"with great power, comes great responsibility.\" Swearing to always protect the innocent from harm, Peter Parker became Spider-Man.",
        rating = 4.9,
        power = 95,
        realName = "Peter Benjamin Parker",
        aliases = listOf(
            "Peter Parker",
            "Captain Universe",
            "Spidey",
            "Wallcrawler",
            "Spider Kid"
        ),
        issues = 16628,
        abilities = listOf(
            "Agility",
            "Danger Sense",
            "Healing",
            "Wall Clinger",
            "Webslinger"
        ),
        collection = "Marvel"
    ),
    Hero(
        id = 1006,
        name = "Thor",
        image = "/images/marvel/thor.jpeg",
        about = "Thor Odinson is the All-father of Asgard /God of Thunder, offspring of All-Father Odin & Elder-Goddess Gaea. Combining the powers of both realms makes him an elder-god hybrid and a being of no perceivable limits. Armed with his enchanted Uru hammer Mjolnir which helps him to channel his godly energies. The mightiest and the most beloved warrior in all of Asgard, a staunch ally for good and one of the most powerful beings in the multiverse/omniverse. Thor is also a founding member of the Avengers.",
        rating = 4.9,
        power = 95,
        realName = "Thor Odinson",
        aliases = listOf(
            "Son of Odin",
            "The God of Thunder",
            "Lord of Asgard"
        ),
        issues = 8175,
        abilities = listOf(
            "Sharingan",
            "Strength",
            "Intelligence"
        ),
        collection = "Marvel"
    ),
    Hero(
        id = 1007,
        name = "Iron Man",
        image = "/images/marvel/iron-man.jpeg",
        about = "Tony Stark was the arrogant son of wealthy, weapon manufacturer Howard Stark. Tony cared only about himself, but he would have a change of heart after he was kidnapped by terrorists and gravely injured. Pressured to create a weapon of mass destruction, Stark instead created a suit of armor powerful enough for him to escape. Tony used his vast resources and intellect to make the world a better place as The Invincible Iron Man. Stark's super hero identity led him to become a founding member of the Avengers.\n",
        rating = 4.9,
        power = 95,
        realName = "Anthony Edward Stark",
        aliases = listOf(
            "Tony Stark",
            "Iron Knight"
        ),
        issues = 10773,
        abilities = listOf(
            "Blast Power",
            "Electricity Control",
            "Gadgets"
        ),
        collection = "Marvel"
    ),
    Hero(
        id = 1008,
        name = "Deadpool",
        image = "/images/marvel/deadpool.jpeg",
        about = "Wade Wilson is a former test subject of the Weapon X program, where he received his regenerative healing factor through the scientific experiments conducted upon him. A prominent enemy, ally and later, member of X-Force. He's famous for breaking the Fourth Wall.",
        rating = 4.2,
        power = 92,
        realName = "Wade Winston Wilson",
        aliases = listOf(
            "Wade Wilson"
        ),
        issues = 3201,
        abilities = listOf(
            "Adaptive",
            "Agility",
            "Blast Power"
        ),
        collection = "Marvel"
    ),
    Hero(
        id = 1009,
        name = "Punisher",
        image = "/images/marvel/punisher.jpeg",
        about = "When U.S. Marine veteran Frank Castle's family's was murdered for witnessing a mob hit, the man vowed to avenge their deaths and became a one-man army in his personal war against the criminal underworld. With a distinct death's head skull adorning his chest, Frank Castle became the vigilante known as the Punisher.",
        rating = 4.5,
        power = 97,
        realName = "Francis Castiglione",
        aliases = listOf(
            "Frank Castle",
            "Johnny Tower"
        ),
        issues = 2744,
        abilities = listOf(
            "Adaptive",
            "Agility",
            "Danger Sense",
            "Weapon Master",
            "Tracking"
        ),
        collection = "Marvel"
    ),
    Hero(
        id = 1010,
        name = "Silver Surfer",
        image = "/images/marvel/silver-surfer.jpeg",
        about = "Norrin Radd of Zenn-La is the mighty herald of Galactus, the devourer of worlds. Gifted with the Power Cosmic and a trusty board that's faster than lightspeed, which he can summon at will whenever needed, Norrin Radd travels to distant reaches throughout the universe as the Silver Surfer.",
        rating = 4.5,
        power = 96,
        realName = "Norrin Radd",
        aliases = listOf(
            "Silver Savage"
        ),
        issues = 2323,
        abilities = listOf(
            "Blast Power",
            "Flight",
            "Gravity control"
        ),
        collection = "Marvel"
    ),
    Hero(
        id = 1011,
        name = "Mr. Fantastic",
        image = "/images/marvel/mr-fanstatic.jpg",
        about = "Reed Richards, also known as Mr. Fantastic, is the leader of the Fantastic Four. He can stretch his body to great distances due to his exposure to cosmic rays while in space. He is also considered to be one of the smartest men alive, using his brain to explore alternate dimensions and save the world alongside his family from science-based threats.",
        rating = 5.0,
        power = 100,
        realName = "Reed Richards",
        aliases = listOf(
            "Stretch",
            "Invincible Man",
            "Doctor Doom",
        ),
        issues = 6667,
        abilities = listOf(
            "Adaptive",
            "Agility",
            "Elasticity",
            "Intellect",
            "Leadership"
        ),
        collection = "Marvel"
    ),
    Hero(
        id = 1012,
        name = "Nick Fury",
        image = "/images/marvel/nick-fury.png",
        about = "Nicholas Joseph Fury served in World War II as the leader of the Howling Commandos. He later became an agent, and eventually director, of S.H.I.E.L.D. Fury is one of the greatest strategic minds in the world, a born leader and a master of espionage. He currently serves as a replacement Watcher.",
        rating = 3.9,
        power = 98,
        realName = "Nicholas Joseph Fury",
        aliases = listOf(
            "Colonel Fury",
            "Commander Fury",
            "Commander of Shield",
        ),
        issues = 4197,
        abilities = listOf(
            "Escape Artist",
            "Gadgets",
            "Leadership"
        ),
        collection = "Marvel"
    ),
    Hero(
        id = 1013,
        name = "Iceman",
        image = "/images/marvel/ice-man.jpeg",
        about = "The youngest member of the original X-Men. Bobby is an Omega-level mutant, although it took some help from Emma Frost to realize this. Bobby's control of ice is vast; he can create shields, clones, spikes, slides and also freeze others. He was recently elected to Krakoa's X-Men",
        rating = 3.4,
        power = 95,
        realName = "Robert Louis Drake",
        aliases = listOf(
            "Bobby Drake",
            "Frosty"
        ),
        issues = 7841,
        abilities = listOf(
            "Adaptive",
            "Agility",
            "Ice Control",
            "Teleport",
            "Water Control"
        ),
        collection = "Marvel"
    ),
    Hero(
        id = 1014,
        name = "Doctor Strange",
        image = "/images/marvel/doctor-strange.jpeg",
        about = "Dr. Stephen Strange was once a gifted but egotistical surgeon who sought out the Ancient One to heal his hands after they were wounded in a car accident. Instead, the Ancient One trained him to become Master of the Mystic Arts and the Sorcerer Supreme of Earth.",
        rating = 4.8,
        power = 99,
        realName = "Stephen Vincent Strange",
        aliases = listOf(
            "Dr. Stephen Strange"
        ),
        issues = 4690,
        abilities = listOf(
            "Animation",
            "Cosmic Awareness",
            "Dimensional Manipulation",
            "Time Travel"
        ),
        collection = "Marvel"
    ),
    Hero(
        id = 1015,
        name = "Professor X",
        image = "/images/marvel/professor-x.jpg",
        about = "Professor Charles Xavier is the creator of the X-Men and founder of the Xavier School for Gifted Youngsters. His dream of peaceful coexistence between mutants and humanity has long been the driving force for the X-Men. An immensely powerful telepath and scientific genius, Xavier was among the world's greatest masterminds. Killed at the hands of a Phoenix crazed Cyclops, Xavier's memory and dream still remains and motivates his X-Men to keep fighting for a world that fears and hates them.",
        rating = 5.0,
        power = 90,
        realName = "Charles Francis Xavier",
        aliases = listOf(
            "Chuck Xavier",
            "Professor Charles Xavier",
        ),
        issues = 7311,
        abilities = listOf(
            "Astral Projection",
            "Hypnosis",
            "Leadership",
            "Psychic",
        ),
        collection = "Marvel"
    ),
)
