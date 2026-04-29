module Snake.Game {
    requires hanyaeger;
    requires org.checkerframework.checker.qual;

    exports snakegame;
    opens snakegame;

    opens audio;
    opens backgrounds;
    opens sprites;

}