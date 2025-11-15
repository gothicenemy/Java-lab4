package ua.edu.lpa.lab4.model;

public class Sentence {
    private final SentenceMember[] members;

    public Sentence(SentenceMember[] members) {
        this.members = members;
    }

    public SentenceMember[] getMembers() {
        return members;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < members.length; i++) {
            SentenceMember member = members[i];

            if (member instanceof PunctuationMark) {
                sb.append(member.toString());
            } else {
                if (i > 0 && !(members[i-1] instanceof PunctuationMark)) {
                    sb.append(" ");
                }
                sb.append(member.toString());
            }
        }
        return sb.toString();
    }
}