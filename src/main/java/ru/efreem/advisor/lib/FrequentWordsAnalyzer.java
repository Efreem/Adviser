package ru.efreem.advisor.lib;

import java.util.ArrayList;

public class FrequentWordsAnalyzer {
    public static String[] prepositions = {"\\sкак\\s","\\sбы\\s","\\sкак-бы\\s","\\sкак бы\\s","\\sно\\s","\\sиз\\s","\\sиз-за\\s",
    "\\sв\\s","\\sмежду\\s","\\sмежду тем\\s","\\sкасаемо\\s","\\sкасательно\\s","\\sкроме\\s","\\sна\\s","\\sоб\\s","\\sобо\\s",
    "\\sпод\\s","\\sподо\\s","\\sподо\\s","\\sнад\\s"};

    public static String[] pronouns = {"\\sон\\s","\\sона\\s","\\sоно\\s","\\sони\\s","\\sэти\\s","\\sэтот\\s","\\sего\\s","\\sеё\\s",
        "\\sтот\\s","\\sстолько\\s","\\sнекто\\s","\\sнечто\\s","\\sнекий\\s","\\sнесколько\\s","\\sкто-то\\s","\\sчто-то\\s","\\sсколько\\s",
        "\\sсколько-нибудь\\s","\\sкакой-либо\\s","\\sкое-что\\s","\\sникто\\s","\\sничто\\s","\\sникакой\\s","\\sничей\\s","\\sнекого\\s",
        "\\sнечего\\s"};

    public static String deleteAllNonCharacterAndNumberSymbolsFromText(String text) {
        String regex = "[^a-zA-Zа-яА-Я0-9]";
        String result = text.replaceAll(regex," ").replaceAll("\\s++"," ");

        return result;
    }

    public static String deleteAllPronounsAndPrepositionsFromFormattedText(String preFormattedText) {
        String result = preFormattedText;

        for (String prepositionRegex : prepositions) {
            result = result.replaceAll(prepositionRegex, " ")
                    .replaceAll("\\s+"," ");
        }

        for (String pronounRegex : pronouns) {
            result = result.replaceAll(pronounRegex," ")
                    .replaceAll("\\s+", " ");
        }

        return result;
    }

    public static String[] transformFormattedTextToFormattedTextArray(String formattedText) {
        String[] formattedTextArray =  formattedText.split("\\s+");
        return formattedTextArray;
    }

    public static String getMostFrequentWordFromFormattedTextArray(String[] formattedTextArray) {
        int count = 0;
        int maxCount = 0;
        String result = "";

        for(int i = 0; i < formattedTextArray.length; i++){
            count = 1;

            if (formattedTextArray[i] == " ") {
                continue;
            }

            for(int j = i+1; j < formattedTextArray.length; j++) {
                if(formattedTextArray[i].equals(formattedTextArray[j])){
                    count++;
                }
            }

            if(count > maxCount){
                maxCount = count;
                result = formattedTextArray[i];
            }
        }

        return result;
    }

    public static String[] deleteMostFrequentWordFromFormattedTextArray(String[] formattedTextArray) {
        String mostFrequentWord = getMostFrequentWordFromFormattedTextArray(formattedTextArray);
        ArrayList<String> result = new ArrayList<>();

        for (String word : formattedTextArray) {
            if (word != mostFrequentWord) {
                result.add(word);
            }
        }

        return result.toArray(new String[result.size()]);
    }

    public static String[] getMostFrequentWordsFromFormattedTextArray(String[] formattedTextArray) {
        ArrayList<String> result = new ArrayList<>();
        int maxLengthOfArray = formattedTextArray.length / 2;

        while (result.size() < 5 || result.size() < maxLengthOfArray) {
            result.add(getMostFrequentWordFromFormattedTextArray(formattedTextArray));
            formattedTextArray = deleteMostFrequentWordFromFormattedTextArray(formattedTextArray);
        }

        return result.toArray(new String[result.size()]);
    }
}