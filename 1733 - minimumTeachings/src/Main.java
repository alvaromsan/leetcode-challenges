import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        int n = 17;
        int[][] languages = {{4,7,2,14,6},{15,13,6,3,2,7,10,8,12,4,9},{16},{10},{10,3},{4,12,8,1,16,5,15,17,13},{4,13,15,8,17,3,6,14,5,10},{11,4,13,8,3,14,5,7,15,6,9,17,2,16,12},{4,14,6},{16,17,9,3,11,14,10,12,1,8,13,4,5,6},{14},{7,14},{17,15,10,3,2,12,16,14,1,7,9,6,4}};
        int[][] friendships = {{4,11},{3,5},{7,10},{10,12},{5,7},{4,5},{3,8},{1,5},{1,6},{7,8},{4,12},{2,4},{8,9},{3,10},{4,7},{5,12},{4,9},{1,4},{2,8},{1,2},{3,4},{5,10},{2,7},{1,7},{1,8},{8,10},{1,9},{1,10},{6,7},{3,7},{8,12},{7,9},{9,11},{2,5},{2,3}};

        int result = minimumTeachings(n,languages,friendships);

        System.out.println("The minimum Teachings is: " + result);


    }

    public static int minimumTeachings(int n, int[][] languages, int[][] friendships) {

        //ArrayList<int[]> friendships_uncommunicated = new ArrayList<>();
        int[] total_language_count = new int[n];
        Set<Integer> total_uncommunicated_friends = new HashSet<>();

        for(int i=0; i< friendships.length;i++) {
            int[] pair_language_count_1 = new int[n];
            int[] pair_language_count_2 = new int[n];
            int friend_1 = friendships[i][0];
            int friend_2 = friendships[i][1];
            int[] known_languages_f1 = languages[friend_1-1];
            int[] known_languages_f2 = languages[friend_2-1];

            boolean can_speak = false;

            for(int language_number: known_languages_f1) {
                pair_language_count_1[language_number-1]++;
            }
            for(int language_number: known_languages_f2) {
                pair_language_count_2[language_number-1]++;
                // we can check if friend_1 speaks the language here already
                if(pair_language_count_1[language_number-1] == 1) {
                    can_speak=true;
                    break;
                }
            }

            if(!can_speak) {
                //friendships_uncommunicated.add(friendships[i]);
                // Play with the return of the .add to see if it's a duplicate, and we need to add it to the total count
                boolean added_friend_1 = total_uncommunicated_friends.add(friend_1);
                boolean added_friend_2 = total_uncommunicated_friends.add(friend_2);
                if(added_friend_1 || added_friend_2) {
                    for (int x = 0; x < total_language_count.length; x++) {
                        total_language_count[x] +=
                                (added_friend_1?pair_language_count_1[x]:0) +
                                        (added_friend_2?pair_language_count_2[x]:0);
                    }
                }
            }
        }

        // We just need to save the pairs that can't communicate
        // Then make the count for the most popular language on those pairs
        // Count how many people don't know that language compared to the amount of people in those pairs
        // Now. We just need to loop through the Set of users and count the languages they speak (after the previous loop)
        // to avoid duplicates - We could also play with the true/false response from .add (SET)

        int most_popular_language = Arrays.stream(total_language_count).max().getAsInt();

        //System.out.println("Uncommunicated friends are: ");

        /*
        for (int[] arr : friendships_uncommunicated) {
            System.out.print(Arrays.toString(arr));
        }
        */

        return (total_uncommunicated_friends.size()-most_popular_language);
    }

    public static int minimumTeachingsTT(int n, int[][] languages, int[][] friendships) {

        int sample_pool = languages.length;
        int[] languages_to_learn = new int[n];
        Arrays.fill(languages_to_learn, sample_pool);

        for(int[] person_languages_i: languages) {
            for (int language_number : person_languages_i) {
                languages_to_learn[language_number-1]--;
            }
        }

        return Arrays.stream(languages_to_learn).min().getAsInt();
    }
}