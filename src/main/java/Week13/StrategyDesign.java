package Week13;

interface TextFormatter {
    String formatText(String text);
}

class UpperCaseFormatter implements TextFormatter {
    @Override
    public String formatText(String text) {
        return text.toUpperCase();
    }
}

class LowerCaseFormatter implements TextFormatter {
    @Override
    public String formatText(String text) {
        return text.toLowerCase();
    }
}

class CamelCaseFormatter implements TextFormatter {
    @Override
    public String formatText(String text) {
        String[] words = text.split("\\s+");
        StringBuilder result = new StringBuilder(words[0].toLowerCase());

        for (int i = 1; i < words.length; i++) {
            result.append(words[i].substring(0, 1).toUpperCase())
                    .append(words[i].substring(1).toLowerCase());
        }

        return result.toString();
    }
}


class TextEditor {
    private TextFormatter textFormatter;

    public void setFormatter(TextFormatter textFormatter) {
        this.textFormatter = textFormatter;
    }

    public String formatText(String text) {
        if (textFormatter == null) {
            throw new IllegalStateException("Text formatter not set.");
        }
        return textFormatter.formatText(text);
    }
}

public class StrategyDesign {
    public static void main(String[] args) {

        TextEditor textEditor = new TextEditor();

        textEditor.setFormatter(new UpperCaseFormatter());
        System.out.println(textEditor.formatText("Hello, World!"));

        textEditor.setFormatter(new LowerCaseFormatter());
        System.out.println(textEditor.formatText("Hello, World!"));

        textEditor.setFormatter(new CamelCaseFormatter());
        System.out.println(textEditor.formatText("Hello World This is a demonstration."));
    }
}
