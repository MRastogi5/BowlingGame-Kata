package org.game.bowling;

public class BowlingGame {

    Frame frames[] = new Frame[10];
    private int total_score;

    public BowlingGame(Frame[] frames) {
        this.frames = frames;
    }

    public Frame[] getFrames() {
        return frames;
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
                    frame.addBonus(frame.getSecond_try() + frame.getExtra_try());
                } else {
                    if (frames[i + 1].getFirst_try() != 10) {
                        frame.addBonus(frames[i + 1].getFirst_try() + frames[i + 1].getSecond_try());
                    }
                    else{
                        frame.addBonus(frames[i + 1].getFirst_try() + frames[i + 2].getFirst_try());
                    }
                }
            }

            total_score += frame.getBonus();


            System.out.print(i + " : ");
            System.out.print(" " + frame.getFirst_try());
            System.out.print(" ," + frame.getSecond_try() + "  Strike :" + frame.IsStrike() + "  Spare :" + frame.isSpare() + " Bonus :" + frame.getBonus());
            System.out.println(" Score after frame :" + total_score);
        }

        return total_score;
    }

    public static void main(String[] args) {

        Frame[] frames = new Frame[10];
        frames[0] = new Frame(1, 4);
        frames[1] = new Frame(4, 5);
        frames[2] = new Frame(6, 4);
        frames[3] = new Frame(5, 5);
        frames[4] = new Frame(10, 0);
        frames[5] = new Frame(0, 1);
        frames[6] = new Frame(7, 3);
        frames[7] = new Frame(6, 4);
        frames[8] = new Frame(10, 0);
        frames[9] = new Frame(2, 8, 6);

        int totalScore = new BowlingGame(frames).play();

        System.out.println("totalScore  : " + totalScore);
    }

}
