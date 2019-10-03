//
//  ViewController.swift
//  lab4MPGCalculator
//
//  Created by Chris Vecchio on 10/1/19.
//  Copyright © 2019 Chris Vecchio. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var milesDriven: UITextField!
    @IBOutlet weak var gallonsUsed: UITextField!
    @IBOutlet weak var passengerLabel: UILabel!
    @IBOutlet weak var passengerStepper: UIStepper!
    @IBOutlet weak var passengerTotal: UILabel!
    @IBOutlet weak var fuelBill: UILabel!
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    @IBAction func updatePassengerNumber(_ sender: UIStepper) {
        if passengerStepper.value == 1 {
            passengerLabel.text = "1 Passenger"
        } else {
            passengerLabel.text = String (format: "%.0f",passengerStepper.value) + " Passengers"
        }
        updateCostTotal()

    }
    
    func updateCostTotal(){
        var price:Float
        var gallons:Float
        if milesDriven.text!.isEmpty{
            price = 0
        } else {
            price = Float(milesDriven.text!)!
        }
        if gallonsUsed.text!.isEmpty{
            gallons = 0
        } else {
            gallons = Float(gallonsUsed.text!)!
        }
        
        let passengerNumber = passengerStepper.value
        //let mpg = miles/gallons
        let total = price*gallons
        var personTotal:Float = 0.0
        if passengerNumber > 0{
            personTotal = total / Float(passengerNumber)
        } else {
            //create a UIAlertController object
            let alert=UIAlertController(title: "Warning", message: "The number of passengers must be greater than 0", preferredStyle: UIAlertController.Style.alert)
            //create a UIAlertAction object for the button
            let cancelAction=UIAlertAction(title: "Ignore", style:UIAlertAction.Style.cancel, handler: nil)
            alert.addAction(cancelAction) //adds the alert action to the alert object
            let okAction=UIAlertAction(title: "1 Passenger", style: UIAlertAction.Style.default, handler: {action in
                self.passengerStepper.value = 1
                self.passengerLabel.text? = "1 Passenger"
                self.updateCostTotal()

            })
            alert.addAction(okAction)
            present(alert, animated: true, completion: nil)
        }
        let currencyFormatter = NumberFormatter()
        currencyFormatter.numberStyle=NumberFormatter.Style.currency //set the number style
      //  avgMPG.text=currencyFormatter.string(from: NSNumber(value: mpg)) //returns a formatted string
        fuelBill.text=currencyFormatter.string(from: NSNumber(value: total))
        passengerTotal.text=currencyFormatter.string(from: NSNumber(value: personTotal))
        
    }
    func textFieldDidEndEditing(_ textField: UITextField) {
        updateCostTotal()
    }
    override func viewDidLoad() {
        milesDriven.delegate=self
        gallonsUsed.delegate=self
        super.viewDidLoad()
        NotificationCenter.default.addObserver(self, selector: #selector(keyboardWillShow), name: UIResponder.keyboardWillShowNotification, object: nil); NotificationCenter.default.addObserver(self, selector: #selector(keyboardWillHide), name: UIResponder.keyboardWillHideNotification, object: nil)
        let tap: UITapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(self.dismissKeyboard)); view.addGestureRecognizer(tap)
        
        // Do any additional setup after loading the view.
    }
    @objc func dismissKeyboard() { view.endEditing(true)
    }

    @objc func keyboardWillShow(notification: NSNotification) {
        if let keyboardSize = (notification.userInfo?[UIResponder.keyboardFrameEndUserInfoKey] as? NSValue)?.cgRectValue {
            if self.view.frame.origin.y == 0 { self.view.frame.origin.y -= keyboardSize.height
            } }
    }
    @objc func keyboardWillHide(notification: NSNotification) { if ((notification.userInfo?[UIResponder.keyboardFrameEndUserInfoKey] as? NSValue)?.cgRectValue) != nil {
        if self.view.frame.origin.y != 0 { self.view.frame.origin.y = 0
        } }
    }
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
}



