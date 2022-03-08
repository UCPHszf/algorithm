package trie;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PrefixandSuffixSearch745 {
    class TrieNode {
        char ch;
        TrieNode[] next;
        Set<Integer> wordIndices;

        TrieNode() {
        }

        TrieNode(char ch) {
            this.ch = ch;
            this.next = new TrieNode[26];
            this.wordIndices = new HashSet<>();
        }
    }

    TrieNode pre = new TrieNode(), suf = new TrieNode();

    void add(String word, int index) {
        TrieNode forward = pre, backward = suf;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (forward.next[ch - 'a'] == null) {
                TrieNode node = new TrieNode(ch);
                forward.next[ch - 'a'] = node;
            }
            forward.next[ch - 'a'].wordIndices.add(index);
            forward = forward.next[ch - 'a'];
        }

        for (int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            if (backward.next[ch - 'a'] == null) {
                TrieNode node = new TrieNode(ch);
                backward.next[ch - 'a'] = node;
            }
            backward.next[ch - 'a'].wordIndices.add(index);
            backward = backward.next[ch - 'a'];
        }
    }

    public PrefixandSuffixSearch745(String[] words) {
        for (int i = 0; i < words.length; i++) {
            add(words[i], i);
        }
    }

    public int f(String prefix, String suffix) {
        TrieNode forward = pre;
        TrieNode backward = suf;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (forward.next[ch - 'a'] == null) {
                forward = null;
                break;
            } else {
                forward = forward.next[ch - 'a'];
            }
        }

        for (int i = suffix.length() - 1; i >= 0; i--) {
            char ch = suffix.charAt(i);
            if (suf.next[ch - 'a'] == null) {
                backward = null;
                break;
            } else {
                backward = backward.next[ch - 'a'];
            }
        }
        if (forward == null || backward == null) return -1;
        int res = -1;
        for (int idx : forward.wordIndices) {
            if (idx > res && backward.wordIndices.contains(idx))
                res = idx;
        }
        return res;
    }
}
