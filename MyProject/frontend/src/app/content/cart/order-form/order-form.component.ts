import {
  Component,
  ChangeDetectionStrategy,
  Output,
  EventEmitter,
} from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  Validators,
  ValidationErrors,
  FormControl,
} from '@angular/forms';

@Component({
  selector: 'sport-coach-order-form',
  templateUrl: './order-form.component.html',
  styleUrls: ['./order-form.component.sass'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class OrderFormComponent {
  @Output()
  public confirm: EventEmitter<FormData> = new EventEmitter<FormData>();

  public form: FormGroup = this._fb.group({
    name: ['Породин Юрий', [Validators.required]],
    telephone: ['+7916 087 2483', [Validators.required, this.phoneValidator]],
    email: ['urecporodin2001@gmail.com', [Validators.email, Validators.required]],
    address: ['Ясеневая 32', [Validators.required]],
  });

  constructor(private readonly _fb: FormBuilder) {}
  public submit(): void {
    if (this.form.valid) {
      this.confirm.emit();
      this.form.reset();
    } else {
      this.form.setErrors({
        email: this.form.get('email')?.errors,
        telephone: this.form.get('telephone')?.errors,
        name: this.form.get('name')?.errors,
      });
    }
  }
  public phoneValidator(control: FormControl): ValidationErrors | null {
    const phone = control.value;
    return phone && phone.substring(0, 1) === '+' && phone.length >= 13
      ? null
      : {
          isNotMatch: true,
          error: 'Телефон должен быть в формате +44 7911 123456',
        };
  }
}
