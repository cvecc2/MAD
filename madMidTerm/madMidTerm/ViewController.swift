//
//  ViewController.swift
//  madMidTerm
//
//  Created by Chris Vecchio on 10/15/19.
//  Copyright © 2019 Chris Vecchio. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var commuteMilesField: UITextField!
    @IBOutlet weak var gasTankLabel: UILabel!
    @IBOutlet weak var commuteTimeLabel: UILabel!
    @IBOutlet weak var gasPurchaseLabel: UILabel!
    @IBOutlet weak var transitControl: UISegmentedControl!
    @IBOutlet weak var calendarOn: UISwitch!
    @IBAction func commuteButton(_ sender: Any) {
    }
    
    @IBAction func gasTankSlider(_ sender: UISlider) {
        let gasTank = sender.value
       gasTankLabel.text = String(format: "%.0f" , gasTank)
        if transitControl.selectedSegmentIndex == 1{
            commuteMilesField.text = "30"s
        }
        else if (transitControl.selectedSegmentIndex == 2){
            commuteMilesField.text = "20"
            
            
        }
    }
    
    
    
    func updateCommuteTime(){
        var miles:Int
        let speed = 20
        if commuteMilesField.text!.isEmpty{
            miles = 0
        } else {
            miles = Int(commuteMilesField.text!)!
        }
        //let mpg = 24
        let time = miles/speed
        //self.updateCommuteTime()
        self.commuteTimeLabel.text=String(format: "%.0f", time)
        

    @IBAction func calculateCommute(_ sender: UIButton) {
        var miles:Int
        let mpg = 24
        let speed = 20
        let busSpeed = 12
        let bikeSpeed = 10
        let carTime = miles/speed
        let busTime = (miles/busSpeed) + 5
        let bikeTime = miles/bikeSpeed
        let gas = miles/mpg
        if commuteMilesField.text!.isEmpty {
            miles = 0
        } else {
            miles = Int(commuteMilesField.text!)!
        }
        commuteTimeLabel.text = String(carTime)
        updateCommuteTime()
        }
  /*
}*/
    
    func calculateCommuteTime() {
        var miles:Int
        let mpg = 24
        let speed = 20
        let busSpeed = 12
        let bikeSpeed = 10
        
        if commuteMilesField.text!.isEmpty {
            miles = 0
        } else {
            miles = Int(commuteMilesField.text!)!
        }
        //if calendarOn == 0 {
        //    calendar = 0.0
        //}
        //else {
        //    calendar = Float(tipPercent.text!)!/100
        //}
        let carTime = miles/speed
        let busTime = (miles/busSpeed) + 5
        let bikeTime = miles/bikeSpeed
        let gas = miles/mpg
        if transitControl.selectedSegmentIndex == 0{
            commuteTimeLabel.text=String(format: "%.0f", carTime)
        }else if {transitControl.selectedSegmentIndex == 1{
            commuteTimeLabel.text=String(format: "%.0f", busTime)
            }
        gasPurchaseLabel.text=String(format: "%.0f", gas)
        }
       //let fuel =
        /*let numberOfPeople = peopleStepper.value
        let tip=amount*pct
        let total=amount+tip
        var personTotal : Float = 0.0 //specify Float so it's not a Double
        if numberOfPeople > 0 {
            personTotal = total / Float(numberOfPeople)
        }else {
            //create a UIAlertController object
            let alert=UIAlertController(title: "Warning", message: "The number of people must be greater than 0", preferredStyle: UIAlertController.Style.alert)
            //create a UIAlertAction object for the button
            let cancelAction=UIAlertAction(title: "Cancel", style:UIAlertAction.Style.cancel, handler: nil)
            alert.addAction(cancelAction) //adds the alert action to the alert object
            let okAction=UIAlertAction(title: "OK", style: UIAlertAction.Style.default, handler: {action in
                self.peopleStepper.value = 1
                self.peopleLabel.text? = "1 person"
                self.updateTipTotals()
            })
            alert.addAction(okAction)
            present(alert, animated: true, completion: nil)
        } //end else
        
        //format results as currency
        let currencyFormatter = NumberFormatter()
        currencyFormatter.numberStyle=NumberFormatter.Style.currency //set the number style
        tipDue.text=currencyFormatter.string(from: NSNumber(value: tip)) //returns a formatted string
        totalDue.text=currencyFormatter.string(from: NSNumber(value: total))
        totalDuePerPerson.text=currencyFormatter.string(from: NSNumber(value: personTotal))
    }
    
    func textFieldDidEndEditing(_ textField: UITextField) {
        updateTipTotals()
    }
         */

    
    
    func textFieldDidEndEditing(_ textField: UITextField) {
        updateCommuteTime()
    }
    override func viewDidLoad() {
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
}


