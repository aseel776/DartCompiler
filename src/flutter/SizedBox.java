package flutter;

public class SizedBox extends Component {
    public SizedBoxAtts sizedBoxAtts;

    public SizedBox(SizedBoxAtts sizedBoxAtts) {
        super("SizedBox", sizedBoxAtts);
        this.sizedBoxAtts = sizedBoxAtts;
    }

    @Override
    public String toString() {
        return "new SizedBox (\n" + sizedBoxAtts.toString() + "\n)";
    }
}