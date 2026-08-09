class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    void backtrack(int[] a, int target, int start,
                    List<Integer> cur, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < a.length; i++) {
            if (a[i] > target)
                continue;

            cur.add(a[i]);

            // i, not i + 1, because the same number can be reused
            backtrack(a, target - a[i], i, cur, ans);

            cur.remove(cur.size() - 1);
        }
    }
}