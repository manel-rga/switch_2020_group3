```puml
left to right direction
title Class Diagram - SP02 CLASS DIAGRAM


hide empty members

package controllers {}

class Application {
}

class CategoryService {
}

class StandardCategory {
}

class CustomCategory {
}

class FamilyService {
}

class AccountService {
}

class TransactionService {
}

class RelationService{
}

class Family {
}

class CashAccount {
}

class Account {
}

class FamilyMember {
}

class MoneyValue {
}

class Relation {
}

class CashTransaction {
}

interface Account {
}

interface Transaction {
}

interface Category{
}

controllers --> Application
Application --> FamilyService : has
Application --> CategoryService : has
Application --> AccountService : has
Application --> TransactionService : has
Application --> RelationService : has

CategoryService --> StandardCategory
'CategoryService -left-> CategoryTreeDTO : creates
'FamilyService -right-> FamilyWithoutAdministratorDTO : creates
FamilyService --> Family : has list
Family --> CashAccount : has
Family --> CustomCategory : \n\n has
Family --> FamilyMember : has list

class StandardCategory implements Category
class CustomCategory implements Category
FamilyMember --> Account : has list
class CashAccount implements Account
class BankAccount implements Account
class BankSavingsAccount implements Account
class CreditCardAccount implements Account

Account -* AccountData : contains
AccountService --> Account: handles
Family --> Relation : has list
RelationService --> Relation : handles
class CashTransaction implements Transaction
TransactionService --> Transaction: handles
Account --> Transaction: has list
AccountData -* MoneyValue : contains
Transaction -* MoneyValue : contains
```

```puml
left to right direction
title Class Diagram - SP02 CLASS DIAGRAM
skinparam linetype ortho

hide empty members

package controllers {}

class Application {
}

class CategoryService {
}

class StandardCategory {
}

class CustomCategory {
}

class FamilyService {
}

class AccountService {
}

class TransactionService {
}

class RelationService{
}

class Family {
}

class CashAccount {
}

class Account {
}

class FamilyMember {
}

class MoneyValue {
}

class Relation {
}

class CashTransaction {
}

interface Account {
}

interface Transaction {
}

interface Category{
}

controllers --> Application
Application --> FamilyService : has
Application --> CategoryService : has
Application --> AccountService : has
Application --> TransactionService : has
Application --> RelationService : has

CategoryService --> StandardCategory
'CategoryService -left-> CategoryTreeDTO : creates
'FamilyService -right-> FamilyWithoutAdministratorDTO : creates
FamilyService --> Family : has list
Family --> CashAccount : has
Family --> CustomCategory : \n\n has
Family --> FamilyMember : has list

class StandardCategory implements Category
class CustomCategory implements Category
FamilyMember --> Account : has list
class CashAccount implements Account
class BankAccount implements Account
class BankSavingsAccount implements Account
class CreditCardAccount implements Account

Account -* AccountData : contains
AccountService --> Account: handles
Family --> Relation : has list
RelationService --> Relation : handles
class CashTransaction implements Transaction
TransactionService --> Transaction: handles
Account --> Transaction: has list
AccountData -* MoneyValue : contains
Transaction -* MoneyValue : contains

```


