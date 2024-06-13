package day7;

import java.util.List;
import java.util.Objects;

public class Solution {
    /**
     * day 7
     * 648. Replace Words (Medium)
     * Runtime: 98.32%
     * Memory: 78.92%
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        String[] split = sentence.split(" ");
        StringBuilder stb = new StringBuilder();

        for (String word : dictionary) {
            trie.insert(word);
        }

        for (String word : split) {
            String toInsert = trie.findPrefix(word);
            if (Objects.equals(toInsert, "")) {
                stb.append(word).append(" ");
            } else {
                stb.append(toInsert).append(" ");
            }
        }

        return stb.toString().trim();
    }

    class TrieVertex {
        TrieVertex[] to = new TrieVertex[26];
        boolean terminal = false;
    }

    class Trie {
        TrieVertex root = new TrieVertex();

        void insert(String s) {
            TrieVertex curr = this.root;
            for (char c : s.toCharArray()) {
                if (curr.to[c-'a'] == null) {
                    curr.to[c-'a'] = new TrieVertex();
                }
                curr = curr.to[c-'a'];
            }
            curr.terminal = true;
        }

        String findPrefix(String s) {
            TrieVertex curr = this.root;
            for (int i=0; i<s.length(); ++i) {
                char c = s.charAt(i);
                TrieVertex node = curr.to[c-'a'];
                if (node == null) {
                    return "";
                }
                if (node.terminal) {
                    return s.substring(0, i+1);
                }

                curr = node;
            }
            return "";
        }
    }
}
