/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jtranspose;

/**
 *
 * @author kerem
 */
public class Note {

    public enum SOUND {C, Cs, D, Ef, E, F, Fs, G, Af, A, Bf, B};
    
    public SOUND sound;
    
    public Note() {
        initialize(null);
    }
    
    public Note(SOUND S) {
        initialize(S);
    }
    
    public Note(String S) {
        SOUND s = parseString(S);
        initialize(s);
    }
    
    @Override
    public String toString() {
        if (sound.equals(SOUND.C)) return "C";
        if (sound.equals(SOUND.Cs)) return "C#";
        if (sound.equals(SOUND.D)) return "D";
        if (sound.equals(SOUND.Ef)) return "Eb";
        if (sound.equals(SOUND.E)) return "E";
        if (sound.equals(SOUND.F)) return "F";
        if (sound.equals(SOUND.Fs)) return "F#";
        if (sound.equals(SOUND.G)) return "G";
        if (sound.equals(SOUND.Af)) return "Ab";
        if (sound.equals(SOUND.A)) return "A";
        if (sound.equals(SOUND.Bf)) return "Bb";
        if (sound.equals(SOUND.B)) return "B";
        
        return null;
    }
    
    public void transpose(int Step) {
        if (Step == 0) return;
        
        int oldPos = getSoundPosition();
        
        if (oldPos == 4) {
            int o = 1;
        }
        
        int newPos = oldPos + Step;
        
        if (newPos < 0) newPos = newPos + 12;
        else if (newPos > 11) newPos = newPos - 12;
        
        sound = getSoundAtPosition(newPos);
    }
    
    public int getSoundPosition () {
        if (sound.equals(SOUND.C)) return 0;
        if (sound.equals(SOUND.Cs)) return 1;
        if (sound.equals(SOUND.D)) return 2;
        if (sound.equals(SOUND.Ef)) return 3;
        if (sound.equals(SOUND.E)) return 4;
        if (sound.equals(SOUND.F)) return 5;
        if (sound.equals(SOUND.Fs)) return 6;
        if (sound.equals(SOUND.G)) return 7;
        if (sound.equals(SOUND.Af)) return 8;
        if (sound.equals(SOUND.A)) return 9;
        if (sound.equals(SOUND.Bf)) return 10;
        if (sound.equals(SOUND.B)) return 11;
        return -1;
    }
    
    private void initialize(SOUND S) {
        sound = S;
    }
    
    public static SOUND getSoundAtPosition(int Position) {
        switch (Position) {
            case 0: return SOUND.C;
            case 1: return SOUND.Cs;
            case 2: return SOUND.D;
            case 3: return SOUND.Ef;
            case 4: return SOUND.E;
            case 5: return SOUND.F;
            case 6: return SOUND.Fs;
            case 7: return SOUND.G;
            case 8: return SOUND.Af;
            case 9: return SOUND.A;
            case 10: return SOUND.Bf;
            case 11: return SOUND.B;
        }
        
        return null;
    }
    
    public static SOUND parseString(String S) {
        String s = S;
        
        if (s.equals("C")) return SOUND.C;
        if (s.equals("C#") || s.equals("Db")) return SOUND.Cs;
        if (s.equals("D")) return SOUND.D;
        if (s.equals("D#") || s.equals("Eb")) return SOUND.Ef;
        if (s.equals("E")) return SOUND.E;
        if (s.equals("F")) return SOUND.F;
        if (s.equals("F#") || s.equals("Gb")) return SOUND.Fs;
        if (s.equals("G")) return SOUND.G;
        if (s.equals("G#") || s.equals("Ab")) return SOUND.Af;
        if (s.equals("A")) return SOUND.A;
        if (s.equals("A#") || s.equals("Bb")) return SOUND.Bf;
        if (s.equals("B")) return SOUND.B;
        
        return null;
    }
    
    public static boolean isStringANote(String S) {
        return parseString(S) != null;
    }
    
}
