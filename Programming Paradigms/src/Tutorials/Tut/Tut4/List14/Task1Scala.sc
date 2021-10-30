Observable<Integer> flow = Observable.range(1, 5)
  .map(v -> v * v)
  .filter(v -> v % 3 == 0)
  .subscribe(System.out::println);