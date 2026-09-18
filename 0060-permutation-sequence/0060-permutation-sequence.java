class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        // factorials
        int[] fact = new int[n + 1];
        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        k--; // convert k to 0-based index

        StringBuilder ans = new StringBuilder();

        for (int i = n; i >= 1; i--) {
            int blockSize = fact[i - 1];

            int index = k / blockSize;
            k = k % blockSize;

            ans.append(numbers.get(index));
            numbers.remove(index);
        }

        return ans.toString();
    }
}