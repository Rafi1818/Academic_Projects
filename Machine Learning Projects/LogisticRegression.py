#!/usr/bin/env python
# coding: utf-8

# In[1]:


# an attempt to understand what goes on behind the sklearn LogisticRegression class
import numpy as np

def sigmoid(x):
    return 1/(1 + np.exp(-x))

class LogisticRegression: 
    def __init__(self, lr=0.001, n_iters=1000): #epoch in Nueral Networ or Deep Learning
        self.lr = lr
        self.n_iters = n_iters
        self.weights = None
        self.bias = None
    
    def fit(self, X, y): # this is to get the best coefficients and bias
        n_samples, n_features = X.shape
        self.weights = np.zeros(n_features)
        self.bias = 0
        
        for _ in range(self.n_iters):
            y_pred = np.dot(X, self.weights) + self.bias
            y_pred = sigmoid(y_pred)
            
            dw = (1/n_samples) * np.dot(X.T, (y_pred-y))
            db = (1/n_samples) * np.sum(y_pred-y)
            
            self.weights = self.weights - self.lr * dw
            self.bias = self.bias - self.lr * db
            
    
    def predict(self, X): # to predict once we have the best coefficients and bias
        y_pred = np.dot(X, self.weights) + self.bias
        y_pred = sigmoid(y_pred)
        prediction = [0 if y <= 0.5 else 1 for y in y_pred]
        return prediction


# In[ ]:




