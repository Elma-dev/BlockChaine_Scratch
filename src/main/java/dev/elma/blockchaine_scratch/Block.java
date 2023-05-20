package dev.elma.blockchaine_scratch;

import lombok.Data;

import java.time.Instant;

//Index: An integer representing the position of the block in the blockchain.
//        ○ Timestamp: A value indicating the time of block creation.
//        ○ Previous Hash: A string storing the hash of the previous block in the
//        chain.
//        ○ Current Hash: A string representing the hash of the current block.
//        ○ Data: Any additional data associated with the block.
@Data
public class Block {
    private Integer index;
    private Instant timestamp;

    private String previousHash;
    private String currentHash;
    private String data;

    public Block(Integer index,String previousHash ,String data) {
        this.index = index;
        this.timestamp = Instant.now();
        this.data = data;
        this.previousHash=previousHash;
        this.currentHash = calculateHash();

    }

    public String calculateHash(){
        String toHash=index+previousHash+timestamp.getEpochSecond()+data;
        return HashUtil.calculateSHA256(toHash);
    }

    public boolean validateBlock(){
        String hash = calculateHash();
        return hash.equals(currentHash);
    }

}
