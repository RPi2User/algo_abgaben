# algo-abgaben

Hier sind die Lösungen zu meinen Übungsaufgaben zu
Algorithmen und Datenstrukturen.

Dieses repo ist quasi privat, wird nicht aktiv gepflegt.
Wenn jemand den Code mag, kann man ihn gern unter der LICENSE verweden.

Keine Garantie, keine Haftung, keine Doku.

```mermaid
flowchart TD
  Start([Start]) --> CheckNull
  CheckNull{a == null?}
  CheckNull -- yes --> ThrowNPE[/"throw NullPointerException"/]
  CheckNull -- no --> Init[/"lo = left\nhi = right\ninsertPos = right + 1"/]
  Init --> LoopCond
  LoopCond{lo <= hi?}
  LoopCond -- yes --> CalcMid["mid = lo + (hi - lo)/2"]
  CalcMid --> Compare["cmp = a[mid].compareTo(key)"]
  Compare --> CmpNeg{cmp < 0?}
  CmpNeg -- yes --> MoveRight["lo = mid + 1"] --> LoopCond
  CmpNeg -- no --> Candidate["insertPos = mid\nhi = mid - 1"] --> LoopCond
  LoopCond -- no --> AfterLoop
  AfterLoop --> InBounds{"insertPos in [left,right] && a[insertPos] == key?"}
  InBounds -- yes --> ReturnFound["return insertPos"]
  InBounds -- no --> IsLeft{"insertPos == left?"}
  IsLeft -- yes --> ReturnLeftMinus1["return left - 1"]
  IsLeft -- no --> ReturnInsert["return insertPos"]
  ReturnFound --> End([End])
  ReturnLeftMinus1 --> End
  ReturnInsert --> End
  ThrowNPE --> End
```

