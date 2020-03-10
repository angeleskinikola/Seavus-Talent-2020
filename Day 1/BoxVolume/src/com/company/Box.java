package com.company;

public class Box {
    int height;
    int width;
    int depth;

    public Box(int height, int width, int depth) {

        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    int volume() {
        return this.height * this.width * this.depth;
    }
}
