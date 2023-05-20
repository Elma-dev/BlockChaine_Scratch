package dev.elma.blockchaine_scratch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlockTest {

    @Test
    void calculateHash() {
    }

    @Test
    void validateBlock() {
        Block block=new Block(0,null,"first block");
        System.out.println(block.getCurrentHash());
        System.out.println(block.calculateHash());
        assertTrue(block.validateBlock());
    }
}