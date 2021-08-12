class Solution {
public:
    vector<int> reversePrint(ListNode* head) {
        vector<int> ans;
        if (head == NULL) {
            return ans;
        }
        ListNode *p = head->next, *q;
        head->next = NULL;
        while (p != NULL) {
            q = p->next;
            p->next = head->next;
            head->next = p;
            p = q;
        }
        p = head->next;
        while (p != NULL) {
            ans.push_back(p->val);
            p = p->next;
        }
        ans.push_back(head->val);
        return ans;
    }
};