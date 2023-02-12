package org.game.bowling;

public class BowlingGame {

    Frame frames[] = new Frame[10];
    private int total_score;
    public BowlingGame(Frame[] frames) {
        this.frames = frames;
    }
    public int play() {
        // (1,4)(4,5)(6,4)(5,5)(10,0)(0,1)(7,3)(6,4)(10,0)(2,8,6)
        for (int i = 0; i < frames.length; i++) {
            Frame frame = frames[i];
            total_score += frame.getScore();

            if (frame.isSpare()) {
                if (i == 9) {
                    frame.addBonus(frame.getExtra_try());
                } else
                    frame.addBonus(frames[i + 1].getFirst_try());
            } else if (frame.IsStrike()) {
                if (i == 9) {
                    frame.addBonus(frame.getExtra_try());
                } else {
                    frame.addBonus(getNextTry(frames, i) + getNextTry(frames, i+1));
                }
            }
            total_score += frame.getBonus();
        }
        return total_score;
    }

    public int getNextTry(Frame[] frame, int i){

            if(frames[i].getFirst_try() == 10){
                if((i+1) >= frames.length){
                    return frames[i].getSecond_try();
                }
                return frames[i+1].getFirst_try();
            }
            else{
                return frames[i].getSecond_try();
            }
    }

}
