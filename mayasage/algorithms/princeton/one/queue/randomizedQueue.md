# Randomized Queue

## Space Complexity

- Enqueue-Dequeue

| Operation | Start | End | Size (end - start + 1) | Length | Size Change (length * 2) | Peak |
|:---------:|:-----:|:---:|:----------------------:|:------:|:------------------------:|:----:|
|     -     |  -1   | -1  |           -            |   1    |            -             |  0   |
|  enqueue  |   0   |  0  |           1            |   -    |            -             |  1   |
|  dequeue  |   1   |  -  |           0            |   -    |            -             |  -   |
|  enqueue  |   -   |  1  |           1            |   2    |          1 * 2           |  -   |
|  dequeue  |   2   |  -  |           0            |   -    |            -             |  -   |
|  enqueue  |   -   |  2  |           1            |   4    |          2 * 2           |  -   |
|  dequeue  |   2   |  -  |           0            |   -    |            -             |  -   |
|  enqueue  |   -   |  3  |           1            |   -    |            -             |  -   |
|  dequeue  |   3   |  -  |           0            |   -    |            -             |  -   |
|  enqueue  |   -   |  4  |           1            |   8    |          4 * 2           |  -   |
|  dequeue  |   4   |  -  |           0            |   -    |            -             |  -   |

- Enqueue * 5 - Dequeue * 4

| Operation | Start | End | Size (end - start + 1) | Length | Size Change (length * 2) | Peak |
|:---------:|:-----:|:---:|:----------------------:|:------:|:------------------------:|:----:|
|     -     |  -1   | -1  |           1            |   1    |            -             |  0   |
|  enqueue  |   0   |  0  |           -            |   -    |            -             |  1   |
|  enqueue  |   -   |  1  |           2            |   2    |          1 * 2           |  2   |
|  enqueue  |   -   |  2  |           3            |   4    |          2 * 2           |  3   |
|  enqueue  |   -   |  3  |           4            |   -    |            -             |  4   |
|  enqueue  |   -   |  4  |           5            |   8    |          4 * 2           |  5   |
|  dequeue  |   1   |  -  |           4            |   -    |            -             |  -   |
|  dequeue  |   2   |  -  |           2            |   -    |            -             |  -   |
|  dequeue  |   3   |  -  |           1            |   5    |            5             |  -   |
|  dequeue  |   4   |  -  |           0            |   -    |            -             |  -   |
