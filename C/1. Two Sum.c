//哈希表  12ms  8.9MB

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

typedef struct Listnode *List;
typedef List Position;
struct Listnode
{
    int Data;
    int Index;
    Position Next;
};
typedef struct HashTbl *HashTable;
struct HashTbl
{
    int TableSize;
    List TheLists;
};

int Hash(int n, int TableSize)
{
    return abs(n) % TableSize;      //测试里有负数
}

int NextPrime(int n)
{
    int i = (n % 2) ? (n + 2) : (n + 1);
    int j;
    while(1){
        for(j = (int)sqrt(i); j > 2; j--){
            if(i % j == 0)
                break;
        }
        if(j == 2)  break;
        else i += 2;
    }
    return i;
}

HashTable InitializeTable(int TableSize)
{
    HashTable H = (HashTable)malloc(sizeof(struct HashTbl));
    H->TableSize = NextPrime(TableSize);
    H->TheLists = (List)malloc(sizeof(struct Listnode) * H->TableSize);
    for(int i = 0; i < H->TableSize; i++)
        H->TheLists[i].Next = NULL;
    return H;
}

Position Find(int n, HashTable H)
{
    Position P;
    P = H->TheLists[Hash(n, H->TableSize)].Next;
    while(P && n != P->Data)
        P = P->Next;
    return P;
}

void Insert(int n, HashTable H, int i)
{
    Position P = Find(n, H);
    Position Newcell;
    if(P == NULL){
        int Pos = Hash(n, H->TableSize);
        Newcell = (Position)malloc(sizeof(struct Listnode));
        Newcell->Index = i;
        Newcell->Data = n;
        Newcell->Next = H->TheLists[Pos].Next;
        H->TheLists[Pos].Next = Newcell;
    }
}

void Destory(HashTable H)
{
    Position P1, P2;
    for(int i = 0; i < H->TableSize; i++){
        P1 = H->TheLists[i].Next;
        while(P1){
            P2 = P1;
            P1 = P1->Next;
            free(P2);
        }
    }
    free(H->TheLists);
    free(H);
}

int* twoSum(int* nums, int numsSize, int target, int* returnSize)
{
    HashTable H = InitializeTable(numsSize);
    for(int i = 0; i < numsSize; i++)
        Insert(nums[i], H, i);
    int *rarray = (int *)malloc(sizeof(int) * 2);
    for(int i = 0; i < numsSize; i++){
        Position tmp = Find(target - nums[i], H);
        if(tmp != NULL && tmp->Index != i){
            rarray[0] = (i < tmp->Index) ? i : tmp->Index;
            rarray[1] = (i > tmp->Index) ? i : tmp->Index;
            *returnSize = 2;
            Destory(H);
            return rarray;
        }
    }
    Destory(H);
    return NULL;
}