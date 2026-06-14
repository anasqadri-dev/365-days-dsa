class Day165 {
    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        int parentSymbol = kthGrammar(n - 1, (k + 1) / 2);
        if (k % 2 == 1) return parentSymbol;
        if (parentSymbol == 0) return 1;
        return 0;
    }
}